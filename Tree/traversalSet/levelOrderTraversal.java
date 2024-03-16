// import java.util.LinkedList;

// class TreeNode {
//     int val;
//     TreeNode left, right;

//     TreeNode(int val) {
//         this.val = val;
//         this.left = null;
//         this.right = null;
//     }
// }

// public class LevelOrderTraversal {
//     public static void levelOrderLineWise(TreeNode root) {
//         LinkedList<TreeNode> queue = new LinkedList<>();
//         queue.addLast(root);
//         int level = 0;

//         while (!queue.isEmpty()) {
//             int size = queue.size();
//             System.out.print("Level " + level + ": ");
//             while (size-- > 0) {
//                 TreeNode currentNode = queue.removeFirst();

//                 System.out.print(currentNode.val + ", ");
//                 if (currentNode.left != null)
//                     queue.addLast(currentNode.left);
//                 if (currentNode.right != null)
//                     queue.addLast(currentNode.right);
//             }
//             level++;
//             System.out.println(); // Move to the next line after printing each level
//         }
//     }

//     public static void main(String[] args) {
//         TreeNode root = new TreeNode(1);
//         root.left = new TreeNode(2);
//         root.right = new TreeNode(3);
//         root.left.left = new TreeNode(4);
//         root.left.right = new TreeNode(5);
//         root.right.left = new TreeNode(6);
//         root.right.right = new TreeNode(7);

//         levelOrderLineWise(root);
//     }
// }



class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        // add your code
          ArrayList<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;

        int[] minMax = new int[2];
        widthOfShadow(root, 0, minMax);
        int width = minMax[1] - minMax[0] + 1;
        for (int i = 0; i < width; i++)
            ans.add(null);

        LinkedList<vpair> que = new LinkedList<>();
        que.addLast(new vpair(root, Math.abs(minMax[0])));

        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {
                vpair p = que.removeFirst();
                TreeNode node = p.node;
                int vl = p.vl;

                if (ans.get(vl) == null)
                    ans.set(vl, node.val);

                if (node.left != null)
                    que.addLast(new vpair(node.left, vl - 1));
                if (node.right != null)
                    que.addLast(new vpair(node.right, vl + 1));
            }
        }

        return ans;
        
    }
}

