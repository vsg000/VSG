 
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class Binarytree {

    static void preorder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    static void postorder(Node root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    static int countNodes(Node root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    static int height(Node root) {
        if (root == null) return -1;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    static boolean search(Node root, int key) {
        if (root == null) return false;
        if (root.data == key) return true;

        return search(root.left, key) || search(root.right, key);
    }

    static boolean update(Node root, int oldValue, int newValue) {
        if (root == null) return false;

        if (root.data == oldValue) {
            root.data = newValue;
            return true;
        }

        if (update(root.left, oldValue, newValue))
            return true;

        return update(root.right, oldValue, newValue);
    }

    static boolean findPath(Node root, int target,
                            ArrayList<Integer> path) {

        if (root == null)
            return false;

        path.add(root.data);

        if (root.data == target)
            return true;

        if (findPath(root.left, target, path) ||
            findPath(root.right, target, path))
            return true;

        path.remove(path.size() - 1);
        return false;
    }

    public static void main(String[] args) {

        Node root = new Node(10);

        root.left = new Node(20);
        root.right = new Node(30);

        root.left.left = new Node(40);
        root.left.right = new Node(50);

        root.right.left = new Node(60);
        root.right.right = new Node(70);

        Scanner sc = new Scanner(System.in);

        int choice;

        do {

            System.out.println("\n========= Binary Tree Menu =========");
            System.out.println("1. Display Tree Nodes");
            System.out.println("2. Preorder Traversal");
            System.out.println("3. Inorder Traversal");
            System.out.println("4. Postorder Traversal");
            System.out.println("5. Count Total Nodes");
            System.out.println("6. Find Height");
            System.out.println("7. Search Node");
            System.out.println("8. Update Node");
            System.out.println("9. Finding the Path");
            System.out.println("10. Exit");

            System.out.print("Enter your choice : ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Root Node : " + root.data);
                    System.out.println("Left Child : " + root.left.data);
                    System.out.println("Right Child : " + root.right.data);
                    System.out.println("Left Child of 20 : " + root.left.left.data);
                    System.out.println("Right Child of 20 : " + root.left.right.data);
                    System.out.println("Left Child of 30 : " + root.right.left.data);
                    System.out.println("Right Child of 30 : " + root.right.right.data);
                    break;

                case 2:
                    System.out.print("Preorder : ");
                    preorder(root);
                    System.out.println();
                    break;

                case 3:
                    System.out.print("Inorder : ");
                    inorder(root);
                    System.out.println();
                    break;

                case 4:
                    System.out.print("Postorder : ");
                    postorder(root);
                    System.out.println();
                    break;

                case 5:
                    System.out.println("Total Nodes : " + countNodes(root));
                    break;

                case 6:
                    System.out.println("Height : " + height(root));
                    break;

                case 7:
                    System.out.print("Enter value to search : ");
                    int key = sc.nextInt();

                    if (search(root, key))
                        System.out.println("Node Found.");
                    else
                        System.out.println("Node Not Found.");

                    break;

                case 8:
                    System.out.print("Old Value : ");
                    int oldVal = sc.nextInt();

                    System.out.print("New Value : ");
                    int newVal = sc.nextInt();

                    if (update(root, oldVal, newVal))
                        System.out.println("Node Updated.");
                    else
                        System.out.println("Node Not Found.");

                    break;

                case 9:
                    System.out.print("Enter target node : ");
                    int target = sc.nextInt();

                    ArrayList<Integer> path = new ArrayList<>();

                    if (findPath(root, target, path)) {

                        for (int i = 0; i < path.size(); i++) {
                            System.out.print(path.get(i));

                            if (i != path.size() - 1)
                                System.out.print(" -> ");
                        }

                        System.out.println();

                    } else {
                        System.out.println("Node Not Found.");
                    }

                    break;

                case 10:
                    System.out.println("Program Terminated.");
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }

        } while (choice != 10);

        sc.close();
    }
}