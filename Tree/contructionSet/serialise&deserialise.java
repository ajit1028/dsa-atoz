public class CodecBinaryTree {
    public void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("# ");
            return;
        }

        sb.append(root.val).append(" ");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    int idx = 0;

    public TreeNode deserialize(String[] arr) {
        if (idx >= arr.length || arr[idx].equals("#")) {
            idx++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(arr[idx++]));
        root.left = deserialize(arr);
        root.right = deserialize(arr);

        return root;
    }

    public TreeNode deserialize(String data) {
        if (data.length() == 0)
            return null;

        idx = 0;
        String[] arr = data.split(" ");
        return deserialize(arr);
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
        CodecBinaryTree codec = new CodecBinaryTree();

        // Example Binary Tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        // Serialize the Binary Tree
        String serialized = codec.serialize(root);
        System.out.println("Serialized Binary Tree: " + serialized);

        // Deserialize the Binary Tree
        TreeNode deserialized = codec.deserialize(serialized);
        System.out.println("Inorder traversal of deserialized Binary Tree:");
        printInorder(deserialized);
    }

    public static void printInorder(TreeNode node) {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.val + " ");
        printInorder(node.right);
    }
}
