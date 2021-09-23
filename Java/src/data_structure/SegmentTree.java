package data_structure;

public class SegmentTree {
    private int[] tree;
    private int size;

    public SegmentTree(int[] data) {
        this.size = data.length;
        this.tree = new int[size * 4];
        buildTree(1, 0, size, data);
    }

    private int buildTree(int index, int left, int right, int[] data) {

        if (left == right) {
            return tree[index] = data[left];
        }

        int mid = (left + right) / 2; // overflow 위험 있음

        int leftValue = buildTree(index * 2, left, mid, data);
        int rightValue = buildTree(index * 2 + 1, mid + 1, right, data);

        return tree[index] = calculateData(leftValue, rightValue);
    }

    private int calculateData(int leftValue, int rightValue) {
        return leftValue + rightValue;
    }

    public int query(int left, int right) {
        return query(1, left, right, 0, size);
    }

    private int query(int index, int queryLeft, int queryRight, int nodeLeft, int nodeRight) {

        // 범위를 벗어난 경우
        if (queryRight < nodeLeft || queryLeft > nodeRight) {
            return 0;
        }

        // 범위에 노드가 완전히 포함되는 경우
        if (queryLeft <= nodeLeft && queryRight >= nodeRight) {
            return tree[index];
        }

        int mid = (nodeLeft + nodeRight) / 2;

        int leftChild = query(index * 2, queryLeft, queryRight, nodeLeft, mid);
        int rightChild = query(index * 2 + 1, queryLeft, queryRight, mid + 1, nodeRight);

        return calculateData(leftChild, rightChild);
    }

    public int update(int index, int newValue) {
        return update(index, newValue, 1, 0, size);
    }

    private int update(int index, int newValue, int node, int left, int right) {

        if (index < left || index > right) {
            return tree[node];
        }

        if (left == right) {
            return tree[node] = newValue;
        }

        int mid = (left + right) / 2;
        int leftChild = update(index, newValue, node * 2, left, mid);
        int rightChild = update(index, newValue, node * 2 + 1, mid + 1, right);

        return tree[node] = calculateData(leftChild, rightChild);
    }

}
