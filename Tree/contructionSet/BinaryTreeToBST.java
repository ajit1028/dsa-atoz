class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTreeToBST {
    TreeNode getMidNode(TreeNode head) {
        if (head == null || head.right == null) {
            return head;
        }
        TreeNode slow = head, fast = head;
        while (fast.right != null && fast.right.right != null) {
            fast = fast.right.right;
            slow = slow.right;
        }
        return slow;
    }

    TreeNode dllToBST(TreeNode head) {
        if (head == null || head.right == null) {
            return head;
        }

        TreeNode midNode = getMidNode(head);
        TreeNode prev = midNode.left, forw = midNode.right;

        midNode.left = midNode.right = forw.left = null;
        if (prev != null) {
            prev.right = null;
        }

        TreeNode root = midNode, leftHead = (prev != null ? head : null), rightHead = forw;

        root.left = dllToBST(leftHead);
        root.right = dllToBST(rightHead);

        return root;
    }

    TreeNode mergeTwoSortedDLL(TreeNode l1, TreeNode l2) {
        if (l1 == null || l2 == null) {
            return (l1 != null) ? l1 : l2;
        }

        TreeNode dummy = new TreeNode(-1);
        TreeNode prev = dummy, c1 = l1, c2 = l2;

        while (c1 != null && c2 != null) {
            if (c1.val <= c2.val) {
                prev.right = c1;
                c1.left = prev;
                c1 = c1.right;
            } else {
                prev.right = c2;
                c2.left = prev;
                c2 = c2.right;
            }
            prev = prev.right;
        }

        if (c1 != null) {
            prev.right = c1;
            c1.left = prev;
        } else {
            prev.right = c2;
            c2.left = prev;
        }

        TreeNode head = dummy.right;
        dummy.right = head.left = null;

        return head;
    }

    TreeNode mergeSort(TreeNode head) {
        if (head == null || head.right == null) {
            return head;
        }

        TreeNode midNode = getMidNode(head);
        TreeNode forwHead = midNode.right;
        forwHead.left = midNode.right = null;

        return mergeTwoSortedDLL(mergeSort(head), mergeSort(forwHead));
    }

    TreeNode getRightMostNode(TreeNode node, TreeNode curr) {
        while (node.right != null && node.right != curr) {
            node = node.right;
        }
        return node;
    }

    TreeNode dll(TreeNode root) {
        TreeNode dummy = new TreeNode(-1);
        TreeNode curr = root, prev = dummy;
        while (curr != null) {
            TreeNode left = curr.left;
            if (left == null) {
                prev.right = curr;
                curr.left = prev;
                prev = prev.right;
                curr = curr.right;
            } else {
                TreeNode rightMostNode = getRightMostNode(left, curr);
                if (rightMostNode.right == null) {
                    rightMostNode.right = curr;
                    curr = curr.left;
                } else {
                    rightMostNode.right = null;
                    prev.right = curr;
                    curr.left = prev;
                    prev = prev.right;
                    curr = curr.right;
                }
            }
        }

        TreeNode head = dummy.right;
        dummy.right = head.left = null;

        return head;
    }

    void display(TreeNode node) {
        if (node == null) {
            return;
        }
        String str = "";
        str += ((node.left != null) ? Integer.toString(node.left.val) : ".");
        str += (" -> " + Integer.toString(node.val) + " <- ");
        str += ((node.right != null) ? Integer.toString(node.right.val) : ".");
        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    TreeNode BTToBST(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode head = dll(root); // Binary Tree to Doubly Linked List
        head = mergeSort(head);    // Doubly Linked List to Sorted Doubly Linked List
        root = dllToBST(head);

        return root;
    }

    public static void main(String[] args) {
        BinaryTreeToBST converter = new BinaryTreeToBST();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(4);

        TreeNode bstRoot = converter.BTToBST(root);
        converter.display(bstRoot);
    }
}
