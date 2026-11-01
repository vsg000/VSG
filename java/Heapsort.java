import java.util.*;
public class Heapsort {
	
	static void maxHeapify(int[] arr, int n, int i) {
		while (true) {
		int largest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		
		if (left < n && arr[left] > arr[largest]) {
			largest = left;
		}
		if (right < n && arr[right] > arr[largest]) {
			largest = right;
		}
		
		if (largest != i) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			
			i = largest;
		}else {
			break;
		}
		}
	}
	static void heapSort(int[] arr) {
		int n = arr.length;
		
		// build max heap
		for (int i = n / 2 - 1; i >= 0 ; i--) {
			maxHeapify(arr, n, i);
		}
		
		//swaping
		for (int i = n - 1; i  > 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			maxHeapify(arr, i, 0);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {40, 10, 30, 50, 20};
		
		System.out.print("Before Sorting, array is : ");
		for (int x : arr) {
			System.out.print(x + "  ");
		}
		heapSort(arr);
		System.out.print("\nAfter Sorting, array is : ");
		for (int x : arr) {
			System.out.print(x + "  ");
		}
	}
}