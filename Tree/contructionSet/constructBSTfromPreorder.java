class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class ConstructBSTFromPreorder {

    public TreeNode bstFromPreorder(int[] preorder) {
        int[] idx = new int[]{0};
        return bstFromPreorder(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE, idx);
    }

    private TreeNode bstFromPreorder(int[] preorder, int lr, int rr, int[] idx) {
        int i = idx[0];
        if (i >= preorder.length || preorder[i] < lr || preorder[i] > rr) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[i]);
        idx[0]++;

        root.left = bstFromPreorder(preorder, lr, root.val, idx);
        root.right = bstFromPreorder(preorder, root.val, rr, idx);

        return root;
    }

    // Example usage
    public static void main(String[] args) {
        ConstructBSTFromPreorder solution = new ConstructBSTFromPreorder();
        int[] preorder = {8, 5, 1, 7, 10, 12};
        TreeNode root = solution.bstFromPreorder(preorder);
        // Perform operations with the BST if needed
    }
}
