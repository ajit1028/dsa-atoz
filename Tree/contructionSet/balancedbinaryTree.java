public class BinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static class BSTPair {
        boolean isBal;
        int h;

        BSTPair() {
            isBal = true;
            h = 0;
        }
    }

    public BSTPair isBalanced_(TreeNode root) {
        if (root == null) {
            BSTPair base = new BSTPair();
            return base;
        }

        BSTPair lp = isBalanced_(root.left);
        BSTPair rp = isBalanced_(root.right);

        BSTPair myPair = new BSTPair();
        myPair.isBal = lp.isBal && rp.isBal;
        if (myPair.isBal && Math.abs(lp.h - rp.h) < 2) {
            myPair.h = Math.max(lp.h, rp.h) + 1;
        } else {
            myPair.isBal = false;
        }

        return myPair;
    }

    public boolean isBalanced(TreeNode root) {
        return isBalanced_(root).isBal;
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        // Example Binary Tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        boolean isBalanced = binaryTree.isBalanced(root);
        System.out.println("Is the Binary Tree balanced? " + isBalanced);
    }
}
