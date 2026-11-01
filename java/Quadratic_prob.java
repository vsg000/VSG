 
    

import java.util.Scanner;

public class Quadratic_prob {
	int[] hashtable;
	int size;
	int count = 0;
	
	Quadratic_prob(int size) {
		this.size = size;
		hashtable = new int[size];
		
		for (int i = 0; i < size; i++) {
			hashtable[i] = -1;
		}
	}
	
	int hashfunction(int key) {
		return key % size;
	}
	void insert(int key) {
		int index = hashfunction(key);
		int i = 0;
		double loadFactor = (double) count / size;
		
		 // Maximum load factor = 0.5
        if (loadFactor >= 0.5) {

            System.out.println(
                "Load factor limit reached. Cannot insert " + key
            );

            return;
        }
		
		while(i < size) {
			int newIndex = (index + i * i) % size;
			
			if (hashtable[newIndex] == -1) {
                hashtable[newIndex] = key;
                System.out.println(
                    key + " inserted at index " + newIndex
                );
                count++;
                return;
            }
			i++;
		}
		 System.out.println("Hash table is full. Cannot insert " + key);
	}
	
	 // Display hash table
    void display() {

        System.out.println("\nHash Table:");

        for (int i = 0; i < size; i++) {
            System.out.println(
                "Index " + i + " : " + hashtable[i]
            );
        }
        double loadFactor = (double) count / size;

        System.out.println("\nNumber of elements : " + count);
        System.out.println("Load Factor : " + loadFactor);
    }
	

   

    public static void main(String[] args) {
        Quadratic_prob qp = new Quadratic_prob(10);
        qp.insert(25);
        qp.insert(35);
        qp.insert(45);
        
        qp.display();

    }
}