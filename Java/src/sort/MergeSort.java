package sort;

public class MergeSort {
    private static int[] tmp;
    public static void sort(int[] arr) {
        tmp = new int[arr.length];
        mergeSort(arr, 0, arr.length-1);
    }

    private static void mergeSort(int[] arr, int start, int end) {
        if(start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid+1, end);
            merge(arr, start, mid, end);
        }
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int idx = start;
        int left = start;
        int right = mid + 1;

        while(left <= mid && right <= end) {
            if(arr[left] < arr[right] ) {
                tmp[idx] = arr[left];
                idx += 1;
                left += 1;
            }
            else {
                tmp[idx] = arr[right];
                idx += 1;
                right += 1;
            }
        }

        while(left <= mid) {
            tmp[idx] = arr[left];
            idx += 1;
            left += 1;
        }

        while(right <= end) {
            tmp[idx] = arr[right];
            idx += 1;
            right += 1;
        }

        for(int i=start; i<=end; i++) {
            arr[i] = tmp[i];
        }
    }
}
