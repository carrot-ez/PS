package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 구간합구하기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] splits = br.readLine().split(" ");
        int N = Integer.parseInt(splits[0]);
        int M = Integer.parseInt(splits[1]);
        int K = Integer.parseInt(splits[2]);

        long[] data = new long[N];
        for (int i = 0; i < N; i++) {
            data[i] = Long.parseLong(br.readLine());
        }

        SegmentTree segmentTree = new SegmentTree(data);

        for (int i = 0; i < M + K; i++) {
            splits = br.readLine().split(" ");
            long command = Long.parseLong(splits[0]);
            long first = Long.parseLong(splits[1]);
            long second = Long.parseLong(splits[2]);

            if (command == 1) {
                // update
                segmentTree.update(first - 1, second);
            } else {
                long query = segmentTree.query(first - 1, second - 1);
                System.out.println(query);
            }
        }


    }

    static class SegmentTree {
        private long[] tree;
        private int size;

        public SegmentTree(long[] data) {
            this.size = data.length - 1;
            this.tree = new long[size * 4];
            buildTree(1, 0, size, data);
        }

        private long buildTree(int node, int left, int right, long[] data) {

            if (left == right) {
                return tree[node] = data[left];
            }

            int mid = (left + right) / 2; // overflow 위험 있음

            long leftValue = buildTree(node * 2, left, mid, data);
            long rightValue = buildTree(node * 2 + 1, mid + 1, right, data);

            return tree[node] = calculateData(leftValue, rightValue);
        }

        private long calculateData(long leftValue, long rightValue) {
            return leftValue + rightValue;
        }

        public long query(long left, long right) {
            return query(1, left, right, 0, size);
        }

        private long query(int node, long queryLeft, long queryRight, int nodeLeft, int nodeRight) {

            // 범위를 벗어난 경우
            if (queryRight < nodeLeft || queryLeft > nodeRight) {
                return 0;
            }

            // 범위에 노드가 완전히 포함되는 경우
            if (queryLeft <= nodeLeft && queryRight >= nodeRight) {
                return tree[node];
            }

            int mid = (nodeLeft + nodeRight) / 2;

            long leftChild = query(node * 2, queryLeft, queryRight, nodeLeft, mid);
            long rightChild = query(node * 2 + 1, queryLeft, queryRight, mid + 1, nodeRight);

            return calculateData(leftChild, rightChild);
        }

        public long update(long index, long newValue) {
            return update(index, newValue, 1, 0, size);
        }

        private long update(long index, long newValue, int node, int left, int right) {

            if (index < left || index > right) {
                return tree[node];
            }

            if (left == right) {
                return tree[node] = newValue;
            }

            int mid = (left + right) / 2;
            long leftChild = update(index, newValue, node * 2, left, mid);
            long rightChild = update(index, newValue, node * 2 + 1, mid + 1, right);

            return tree[node] = calculateData(leftChild, rightChild);
        }

        private void printTree() {
            for (long l : tree) {
                System.out.print(l + " ");
            }
            System.out.println();
        }

    }

}
