 
import java.util.*;

class Node3 implements Comparable<Node3> {
    char ch;
    int freq;
    Node3 left;
    Node3 right;

    Node3(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
        this.left = null;
        this.right = null;
    }

    public int compareTo(Node3 other) {
        return Integer.compare(this.freq, other.freq);
    }
}

public class Huffmancode {

    // Generate Huffman Codes
    static void printCode(Node3 root, String code) {

        if (root == null) {
            return;
        }

        // Leaf Node
        if (root.left == null && root.right == null) {
            System.out.println(root.ch + " : "
                    + (code.isEmpty() ? "0" : code));
            return;
        }

        // Left = 0
        printCode(root.left, code + "0");

        // Right = 1
        printCode(root.right, code + "1");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        PriorityQueue<Node3> pq = new PriorityQueue<>();

        System.out.print("Enter total no of character : ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Number of characters must be positive.");
            sc.close();
            return;
        }

        for (int i = 0; i < n; i++) {

            System.out.print("Enter Character : ");
            char ch = sc.next().charAt(0);

            System.out.print("Enter frequency : ");
            int freq = sc.nextInt();

            if (freq <= 0) {
                System.out.println("Frequency must be positive.");
                sc.close();
                return;
            }

            pq.add(new Node3(ch, freq));
        }

        // Build Huffman Tree
        while (pq.size() > 1) {

            Node3 left = pq.poll();
            Node3 right = pq.poll();

            Node3 parent = new Node3(
                    '-', left.freq + right.freq
            );

            parent.left = left;
            parent.right = right;

            pq.add(parent);
        }

        // Get root
        Node3 root = pq.poll();

        System.out.println("\n===== Huffman Codes =====");

        printCode(root, "");

        sc.close();
    }
}