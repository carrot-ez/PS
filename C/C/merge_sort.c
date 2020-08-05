#include "merge_sort.h"

void merge_sort(int arr[], int left, int right) {
	if (left < right) {
		int mid = (left + right) / 2;

		merge_sort(arr, left, mid);
		merge_sort(arr, mid + 1, right);

		merge(arr, left, mid, right);
	}
}

void merge(int arr[], int left, int mid, int right) {
	int i = left;
	int l_start = left;
	int r_start = mid + 1;

	// ���ʰ� ������ ��Ƽ���� ���ϸ� ����
	while (l_start <= mid && r_start <= right) {
		if (arr[l_start] <= arr[r_start]) {
			sorted[i] = arr[l_start];
			l_start += 1;
		}
		else {
			sorted[i] = arr[r_start];
			r_start += 1;
		}
		i += 1;
	}

	// ���� ������ ��� push
	while (l_start <= mid) {
		sorted[i] = arr[l_start];
		i += 1;
		l_start += 1;
	}
	while (r_start <= right) {
		sorted[i] = arr[r_start];
		i += 1;
		r_start += 1;
	}

	// sort�� �迭�� ���� �迭�� ����
	for (int i = left; i <= right; i++) {
		arr[i] = sorted[i];
	}
}