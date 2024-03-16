import java.util.ArrayList;
import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class RightViewOfBinaryTree {
    public static void rightView(TreeNode root) {
        if (root == null) {
            return;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);

        ArrayList<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            ans.add(queue.getFirst().val); // Add the value of the first node at each level
            boolean isFirstNode = true; // Flag to track the first node at each level

            while (size-- > 0) {
                TreeNode currentNode = queue.removeFirst();

                if (currentNode.right != null) {
                    queue.addLast(currentNode.right);
                }
                if (currentNode.left != null) {
                    queue.addLast(currentNode.left);
                }

                if (isFirstNode) {
                    System.out.print(currentNode.val + " "); // Print the rightmost node at each level
                    isFirstNode = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        System.out.println("Right view of the binary tree:");
        rightView(root);
    }
}
