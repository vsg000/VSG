import java.util.*;

public class Bst_A1 {
	static class Node {
		int data;
		Node left;
		Node right;
		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	static Node root;
	
	static Node insert(Node root, int val) {
		if (root == null) {
			return new Node(val);
		}
		if(val < root.data) {
			root.left = insert(root.left, val);
		}
		else if(val > root.data) {
			root.right = insert(root.right, val);
		}else {
			System.out.println("Duplicate entries not allowed.....");
		}
		
		return root;
	}
	
	static int findMax(Node root) {
		if (root == null) {
			System.out.print("Tree is empty...");
			return -1;
		}
		
		while (root.right != null) {
			root = root.right;
		}
		
		return root.data;
	}
	static int findMin(Node root) {
		if (root == null) {
			System.out.print("Tree is empty...");
			return -1;
		}
		
		while (root.left != null) {
			root = root.left;
		}
		
		return root.data;
	}
	
	static boolean search (Node root, int key) {
		if (root == null) {
			return false;
		}
		if (key == root.data) {
			return true;
		}
		if (key < root.data) {
			return search(root.left, key);
		}else {
			return search(root.right, key);
		}
	}
	
	static Node deletion(Node root, int val) {
		if (root == null) {
			return null;
		}
		if(val < root.data) {
			root.left = deletion(root.left, val);
		}else if (val > root.data) {
			root.right = deletion(root.right, val);
		}else {
			if (root.left == null && root.right == null) {
				return null;
			}
			if(root.left == null) {
				return root.right;
			}
			if(root.right == null) {
				return root.left;
			}
			int successor = findMin(root.right);
			root.data = successor;
			root.right = deletion(root.right, successor);
		}
		return root;
	}
	
	static void inorder(Node root) {
		if (root == null) {
			return;
		}
		inorder(root.left);
		System.out.print(root.data + "  ");
		inorder(root.right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int choice;
		
		do {
			System.out.print("\n====BINARY SEARCH TREE====");
			System.out.print("\n1.Insertion");
			System.out.print("\n2.Deletion");
			System.out.print("\n3.finding Max value");
			System.out.print("\n4.finding min value");
			System.out.print("\n5.display Inorder traversal");
			System.out.print("\n6.searching");
			System.out.print("\n7.Exit");
			
			System.out.print("\nEnter your choice : ");
			choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				System.out.print("Enter value : ");
				int val = sc.nextInt();
				root = insert(root, val);
				System.out.print(val + " inserted successfully!!");
			break;
			
			case 2:	
				if (root == null) {
					System.out.print("tree is already empty!!");
					break;
				}
				System.out.print("Which node you want to delete : ");
				val = sc.nextInt();
				if(search(root, val)) {
					root = deletion(root, val);
					System.out.print(val + " deleted successfully!!");
				}else {
					System.out.print(val + " not found");
				}
			break;
				
			case 3:
				int max = findMax(root);
				if (max != -1) {
					System.out.print("Max value is : " + max);
				}	
			break;
			case 4:
				int min= findMin(root);
				if (min != -1) {
					System.out.print("Min value is : " + min);
				}	
			break;
			
			case 5:
				if (root == null) {
					System.out.print("tree is empty!!");
					break;
				}
				System.out.print("Inorder traversal : ");
				inorder(root);
			break;
			
			case 6:
				if (root == null) {
					System.out.print("tree is empty!!");
					break;
				}
				System.out.print("Enter key to be searched : ");
				val = sc.nextInt();
				if(search(root, val)) {
					System.out.print(val + " present in that tree");
				}else {
					System.out.print(val + " not present in that tree");
				}
			break;
			
			case 7:
					System.out.print("Program terminated.....");
			break;
			default:
				System.out.println("Invalid input!!");
				
			
			}
		}while (choice != 7);

	}

}