class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class ConstructBSTFromPostorder {

    public TreeNode bstFromPostorder(int[] postorder) {
        int[] idx = new int[]{postorder.length - 1};
        return bstFromPostorder(postorder, Integer.MIN_VALUE, Integer.MAX_VALUE, idx);
    }

    private TreeNode bstFromPostorder(int[] postorder, int lr, int rr, int[] idx) {
        int i = idx[0];
        if (i <= -1 || postorder[i] < lr || postorder[i] > rr) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[i]);
        idx[0]--;

        root.right = bstFromPostorder(postorder, root.val, rr, idx);
        root.left = bstFromPostorder(postorder, lr, root.val, idx);

        return root;
    }

    // Example usage
    public static void main(String[] args) {
        ConstructBSTFromPostorder solution = new ConstructBSTFromPostorder();
        int[] postorder = {4, 1, 3, 7, 6, 5, 8};
        TreeNode root = solution.bstFromPostorder(postorder);
        // Perform operations with the BST if needed
    }
}
