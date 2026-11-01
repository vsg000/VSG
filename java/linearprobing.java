 
import java.util.*;
public class linearprobing {
	static int size;
	static int [] hashtable;
	static int count = 0;
	
	
	static void insert(int key) {
		int index = key % size;
		while(hashtable[index] != -1) {
			index = (index + 1) % size;
		}
		
		hashtable[index] = key;
	}
	
	
	static void display() {
		
		System.out.println("====HASH TABLE====");
		for (int i = 0; i < size; i++) {
			if(hashtable[i] == -1) {
				System.out.println(i + " ---> " + " Empty");
			}else {
			System.out.println(i + " ---> " + hashtable[i]);
			}
			
			
		}
		double loadFactor = (double) count/ size;
		System.out.println("Current Load factor : " + loadFactor);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter size of the hashtable : ");
		size = sc.nextInt();
		
		hashtable = new int[size];
		
		for(int i = 0; i < size; i++) {
			hashtable[i] = -1;
		}
		
		System.out.println("Enter total elements : ");
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			System.out.print("Enter element " + (i + 1) + " --> ");
			int key = sc.nextInt();
			count++;
			double loadFactor = (double) count / size;
			if(loadFactor >= 0.6) {
				System.out.println(key + " can't inserted");
				break;
			}else {
				insert(key);
				System.out.println(key + " inserted successfully");
			}
			
		}

		display();

	}

}