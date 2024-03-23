public static TreeNode buildTree(int[] preorder, int psi, int pei, int[] inorder, int isi, int iei) {
    if (psi > pei)
        return null;

    int idx = isi;
    while (inorder[idx] != preorder[psi])
        idx++;

    int tnel = idx - isi;
    TreeNode root = new TreeNode(preorder[psi]);
    root.left = buildTree(preorder, psi + 1, psi + tnel, inorder, isi, idx - 1);
    root.right = buildTree(preorder, psi + tnel + 1, pei, inorder, idx + 1, iei);

    return root;
}

public static TreeNode buildTree(int[] preorder, int[] inorder) {
    int n = preorder.length;
    return buildTree(preorder, 0, n - 1, inorder, 0, n - 1);
}

public static void main(String[] args) {
    int[] preorder = {3, 9, 20, 15, 7};
    int[] inorder = {9, 3, 15, 20, 7};
    TreeNode root = buildTree(preorder, inorder);
    System.out.println("BST constructed from preorder and inorder traversals:");
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


//BST constructed from preorder and inorder traversals:
9 3 15 20 7
