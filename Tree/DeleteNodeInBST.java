class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public int getMin(TreeNode root) {
        while (root.left != null)
            root = root.left;
        return root.val;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;

        if (root.val < key)
            root.right = deleteNode(root.right, key);
        else if (root.val > key)
            root.left = deleteNode(root.left, key);
        else {
            if (root.left == null || root.right == null) {
                TreeNode rNode = root.left != null ? root.left : root.right;
                root.left = root.right = null;
                return rNode;
            }

            int minEle = getMin(root.right);
            root.val = minEle;

            root.right = deleteNode(root.right, minEle);
        }

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

        // Delete a node with value 3 from the BST
        TreeNode newRoot = solution.deleteNode(root, 3);

        // Print the inorder traversal of the BST to verify deletion
        System.out.println("Inorder traversal after deletion:");
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
