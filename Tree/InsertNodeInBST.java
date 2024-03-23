class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);

        if (root.val < val)
            root.right = insertIntoBST(root.right, val);
        else
            root.left = insertIntoBST(root.left, val);

        return root;
    }

    // Example usage:
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Create a BST
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        // Insert a node with value 7 into the BST
        TreeNode newRoot = solution.insertIntoBST(root, 7);

        // Print the inorder traversal of the BST to verify insertion
        System.out.println("Inorder traversal after insertion:");
        printInorder(newRoot);
    }

    // Helper method for inorder traversal
    private static void printInorder(TreeNode node) {
        if (node != null) {
            printInorder(node.left);
            System.out.print(node.val + " ");
            printInorder(node.right);
        }
    }
}
