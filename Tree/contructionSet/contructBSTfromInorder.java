class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTree {
    public TreeNode buildBSTFromInorder(int[] inorder) {
        return buildTree(inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(inorder[mid]);

        node.left = buildTree(inorder, start, mid - 1);
        node.right = buildTree(inorder, mid + 1, end);

        return node;
    }

    public static void main(String[] args) {
        int[] inorder = {1, 2, 3, 4, 5};
        BinaryTree tree = new BinaryTree();
        TreeNode root = tree.buildBSTFromInorder(inorder);
        System.out.println(root);
    }
}
