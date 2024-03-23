public static TreeNode constructFromPrePost(int[] postOrder, int ppsi, int ppei, int[] preOrder, int psi, int pei) {
    if (psi > pei)
        return null;

    TreeNode root = new TreeNode(preOrder[psi]);
    if (psi == pei)
        return root;

    int idx = ppsi;
    while (postOrder[idx] != preOrder[psi + 1])
        idx++;

    int tnel = idx - ppsi + 1;
    root.left = constructFromPrePost(postOrder, ppsi, ppsi + tnel - 1, preOrder, psi + 1, psi + tnel);
    root.right = constructFromPrePost(postOrder, ppsi + tnel, ppei - 1, preOrder, psi + tnel + 1, pei);

    return root;
}

public static TreeNode constructFromPrePost(int[] preOrder, int[] postorder) {
    int n = postorder.length;
    return constructFromPrePost(postorder, 0, n - 1, preOrder, 0, n - 1);
}

static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public static void main(String[] args) {
    int[] preOrder = {1, 2, 4, 5, 3, 6, 7};
    int[] postOrder = {4, 5, 2, 6, 7, 3, 1};

    TreeNode root = constructFromPrePost(preOrder, postOrder);
    System.out.println("Binary Tree constructed from preorder and postorder traversals:");
    printInorder(root);
}

public static void printInorder(TreeNode node) {
    if (node == null)
        return;
    printInorder(node.left);
    System.out.print(node.val + " ");
    printInorder(node.right);
}

//Binary Tree constructed from preorder and postorder traversals:
4 2 5 1 6 3 7

