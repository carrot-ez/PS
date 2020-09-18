package sort;

public class SelectionSort {
    public static void sort(int[] arr) {
        int tmp;
        for(int i=0; i<arr.length; i++) {
            int max = i;
            for(int j=i+1; j<arr.length; j++) {
                if(arr[max] < arr[j]) {
                    max = j;
                }
            }
            tmp = arr[i];
            arr[i] = arr[max];
            arr[max] = tmp;
        }
    }
}
