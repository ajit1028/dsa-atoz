import java.util.Stack;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

public class BinaryTree {
    public static void iterativePostorder(Node root) {
        if (root == null) return;

        Stack<Node> stack = new Stack<>();
        Node current = root;
        Node lastVisited = null;

        while (current != null || !stack.isEmpty()) {
            // Reach the leftmost node of the current subtree
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            Node peekNode = stack.peek();

            // Check if the right subtree needs to be processed or if it's already processed
            if (peekNode.right != null && peekNode.right != lastVisited) {
                current = peekNode.right; // Move to the right subtree
            } else {
                // Process the node (print or perform desired operation)
                Node poppedNode = stack.pop();
                System.out.print(poppedNode.data + " ");
                lastVisited = poppedNode;
            }
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

        System.out.println("Postorder traversal (iterative using one stack):");
        iterativePostorder(root);
    }
}
