#include<stdio.h>
#include"heap.h"

int main() {
	int arr[] = { 5, 3, 7, 10, 13, 22, 3, 0, 143 };
	heap_sort(arr, 9);
	
	for (int i = 0; i < 9; i++) {
		printf("%d\n", arr[i]);
	}
}