package sort;

public class QuickSort {
    public static void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int start, int end) {
        if(start < end) {
            int partition = partition(arr, start, end);
            quickSort(arr, start, partition);
            quickSort(arr, partition + 1, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int left = start;
        int right = end;

        while(left < right) {
            while(arr[left] < pivot) {
                left += 1;
            }
            while(arr[right] > pivot) {
                right -= 1;
            }

            if(left < right) {
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
                left += 1;
                right -= 1;
            }
        }
        // loof를 빠져 나왔을 때 right 는 pivot보다 작거나 같다.
        return right;
    }
}
