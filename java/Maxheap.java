import java.util.*;
public class MaxHeap {
	int []heap;
	int capacity;
	int size;
	
	MaxHeap(int capacity) {
		this.capacity = capacity;
		heap = new int[capacity];
		size = 0;
	}
	
 
	
	void insert(int value) {
		if (size == capacity) {
			System.out.print("Heap is full");
			return;
		}
		heap[size] = value;
		int index = size;
		size++;
		
		while (index > 0) {
			int parent = (index - 1) / 2;
			
			if(heap[parent] < heap[index]) {
				int temp = heap[parent];
				heap[parent] = heap[index];
				heap[index] = temp;
				
				index = parent;
			}else {
				break;
			}
		}
		System.out.print(value + " inserted successfully");
	}
	
	int deletion() {
		if(size == 0) {
			System.out.print("Heap is empty !!");
			return -1;
		}
		
		int max = heap[0];
		heap[0] = heap[size - 1];
		size--;
		
		int index = 0;
		
		while (true) {
			int left = 2 * index + 1;
			int right = 2 * index + 2;
			int largest = index;
			
			if(left  < size && heap[left] > heap[largest]) {
				largest = left;
			}
			
			if(right < size && heap[right] > heap[largest]) {
				largest = right;
			}
			
			if(largest != index) {
				//swap
				
				int temp = heap[index];
				heap[index] = heap[largest];
				heap[largest] = temp;
				
				index = largest;
			}else {
				break;
			}
		}
		
		return max;
	}
	
	
	 // Display heap
    void display() {

        if (size == 0) {
            System.out.println("Heap is Empty.");
            return;
        }

        System.out.print("Max Heap: ");

        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }

        System.out.println();
    }
    // Get maximum element
    int getMax() {

        if (size == 0) {
            System.out.println("Heap is Empty.");
            return -1;
        }

        return heap[0];
    }
    
    
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Heap Capacity: ");
        int capacity = sc.nextInt();

        MaxHeap mh = new MaxHeap(capacity);

        int choice;

        do {
            System.out.println("\n===== MAX HEAP MENU =====");
            System.out.println("1. Insert");
            System.out.println("2. Delete Maximum");
            System.out.println("3. Get Maximum");
            System.out.println("4. Display");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Value: ");
                    int value = sc.nextInt();
                    mh.insert(value);
                    break;
                    
                case 2:
                		int max = mh.deletion();
                		
                		if(max != -1) {
                			System.out.print("Deletion element is : " + max);
                			
                		}
                		break;
                    
                

                case 3:
                    System.out.println("Maximum Value: " + mh.getMax());
                    break;

                case 4:
                    mh.display();
                    break;

                case 5:
                    System.out.println("Program Terminated.");
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }

        } while (choice != 5);

        sc.close();

	}

}