/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode rightMostNode(TreeNode node,TreeNode curr)
    {
        while(node.right!=null && node.right!=curr) node = node.right;
        return node;
    }
    
    public boolean isValidBST(TreeNode root) {
       
        long prev=-(long)1e13;
        TreeNode curr=root;
        while(curr!=null)
        {
            TreeNode left = curr.left;
            if(left==null)
            {
               if(prev >= curr.val) return false;
                prev=curr.val;
                
                curr=curr.right;
                
            }
            else
            {
                TreeNode getRightMostNode = rightMostNode(left,curr);
                if(getRightMostNode.right == null)
                {
                    getRightMostNode.right = curr;
                    curr = curr.left;
                }
                else
                {
                  getRightMostNode.right=null;

                    if(prev>=curr.val) return false;
                    prev=curr.val;

                    curr=curr.right;
                }
            }
        }
        return true;
    }
}