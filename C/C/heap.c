#include "heap.h"

void heap_sort(int arr[], int len) {
	int tmp; // for swap

	// 1. build heap
	build_max_heap(arr, len);

	// 2. swap root node and last unsorted node
	for (int i = len - 1; i >= 0; i--) {
		tmp = arr[0];
		arr[0] = arr[i];
		arr[i] = tmp;

		heapify(arr, i, 0);
	}
}

void build_max_heap(int arr[], int len) {
	int mid = len / 2; // idx of last node that have child.

	for (int i = mid; i >= 0; i--) {
		heapify(arr, len, i);
	}
}

void heapify(int arr[], int len, int x) {
	// start index = 0, left child = 2x + 1, right child = 2x + 2
	int largest_idx = x;
	int left_idx = 2 * x + 1;
	int right_idx = 2 * x + 2;
	int tmp; // for swap

	// set largest_idx
	if (left_idx < len && arr[left_idx] > arr[largest_idx]) {
		largest_idx = left_idx;
	}

	if (right_idx < len && arr[right_idx] > arr[largest_idx]) {
		largest_idx = right_idx;
	}

	// swap parent and largest child
	if (largest_idx != x) {
		tmp = arr[largest_idx];
		arr[largest_idx] = arr[x];
		arr[x] = tmp;

		heapify(arr, len, largest_idx);
	}
}