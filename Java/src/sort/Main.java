package sort;

public class Main {
    public static void main(String args[]) {
        int[] arr = {4, 2, 7, 9, 10, 23, 0, 9, 2};
        InsertionSort.sort(arr);

        for(int e : arr) {
            System.out.print(e+" ");
        }
    }
}
