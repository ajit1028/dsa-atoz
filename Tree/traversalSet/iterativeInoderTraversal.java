import java.util.Stack;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}
//use can also use morris traversal
public class BinaryTree {
    public static void iterativeInorder(Node root) {
        if (root == null) return;

        Stack<Node> stack = new Stack<>();
        Node current = root;

        while (current != null || !stack.isEmpty()) {
            // Reach the leftmost node of the current subtree
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // Pop the top node from the stack and print its value
            current = stack.pop();
            System.out.print(current.data + " ");

            // Move to the right subtree
            current = current.right;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("Inorder traversal (iterative):");
        iterativeInorder(root);
    }
}
