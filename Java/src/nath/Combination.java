package nath;

public class Combination {

    // nCr = n-1Cr-1 + n-1Cr
    public static int getCombination(int n, int r) {
        if(r == 0 || r == n) {
            return 1;
        }
        return getCombination(n-1, r-1) + getCombination(n-1, r);
    }

    // using back tracking
    public static void printCombination1(int[] arr, boolean visited[], int start, int n, int r) {
        if(r == 0) {
            printArr(arr, visited);
            return;
        }

        for(int i=start; i<n; i++) {
            visited[i] = true;
            printCombination1(arr, visited, i+1, n, r-1);
            visited[i] = false;
        }
    }

    // using recursive
    public static void printCombination2(int[] arr, boolean[] visited, int start, int n, int r) {
        if(r == 0) {
            printArr(arr, visited);
            return;
        }
        if(start == n) {
            return;
        }

        visited[start] = true;
        printCombination2(arr, visited, start+1, n, r-1); // 하나 골랐음.
        visited[start] = false;
        printCombination2(arr, visited, start+1, n, r); // 안고르고 다음으로 넘어감.
    }

    private static void printArr(int[] arr, boolean[] visited) {
        for(int i=0; i<arr.length; i++) {
            if(visited[i]) {
                System.out.print(arr[i]+" ");
            }
        }
        System.out.println();
    }
}
