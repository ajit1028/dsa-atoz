import java.util.ArrayList;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

public class BinaryTree {
    public static void addLeftBoundary(Node root, ArrayList<Integer> res) {
        Node cur = root.left;

        while (cur != null) {
            if (!isLeaf(cur))
                res.add(cur.data);

            if (cur.left != null)
                cur = cur.left;
            else
                cur = cur.right;
        }
    }

    public static void addRightBoundary(Node root, ArrayList<Integer> res) {
        Node cur = root.right;
        ArrayList<Integer> tmp = new ArrayList<>();

        while (cur != null) {
            if (!isLeaf(cur))
                tmp.add(cur.data);

            if (cur.right != null)
                cur = cur.right;
            else
                cur = cur.left;
        }

        for (int i = tmp.size() - 1; i > 0; --i) {
            res.add(tmp.get(i));
        }
    }

    public static void addLeaves(Node root, ArrayList<Integer> res) {
        if (isLeaf(root)) {
            res.add(root.data);
            return;
        }

        if (root.left != null)
            addLeaves(root.left, res);

        if (root.right != null)
            addLeaves(root.right, res);
    }

    public static ArrayList<Integer> printBoundary(Node node) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (!isLeaf(node))
            ans.add(node.data);

        addLeftBoundary(node, ans);
        addLeaves(node, ans);
        addRightBoundary(node, ans);

        return ans;
    }

    public static boolean isLeaf(Node node) {
        return node != null && node.left == null && node.right == null;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.right.left = new Node(8);
        root.left.right.right = new Node(9);

        ArrayList<Integer> result = printBoundary(root);
        System.out.println(result);
    }
}
