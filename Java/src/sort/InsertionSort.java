package sort;

public class InsertionSort {
    public static void sort(int[] arr) {
        int j;
        int tmp;
        for(int i=1; i<arr.length; i++) {
            tmp = arr[i];
            for(j = i-1; j >= 0 && tmp < arr[j]; j--) {
                arr[j+1] = arr[j];
            }
            arr[j+1] = tmp;
        }
    }
}
