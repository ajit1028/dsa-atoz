public static TreeNode buildTreeFromPostAndIn(int[] postOrder, int psi, int pei, int[] inorder, int isi, int iei) {
    if (psi > pei)
        return null;

    int idx = isi;
    while (inorder[idx] != postOrder[pei])
        idx++;

    int tnel = idx - isi;
    TreeNode root = new TreeNode(postOrder[pei]);
    root.left = buildTreeFromPostAndIn(postOrder, psi, psi + tnel - 1, inorder, isi, idx - 1);
    root.right = buildTreeFromPostAndIn(postOrder, psi + tnel, pei - 1, inorder, idx + 1, iei);

    return root;
}

public static TreeNode buildTreeFromPostAndIn(int[] inorder, int[] postorder) {
    int n = inorder.length;
    return buildTreeFromPostAndIn(postorder, 0, n - 1, inorder, 0, n - 1);
}

public static void main(String[] args) {
    int[] inorder = {9, 3, 15, 20, 7};
    int[] postorder = {9, 15, 7, 20, 3};
    TreeNode root = buildTreeFromPostAndIn(inorder, postorder);
    System.out.println("Binary Tree constructed from postorder and inorder traversals:");
    printInorder(root);
}

public static void printInorder(TreeNode node) {
    if (node == null)
        return;
    printInorder(node.left);
    System.out.print(node.val + " ");
    printInorder(node.right);
}

static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}
//Binary Tree constructed from postorder and inorder traversals:
9 3 15 20 7

