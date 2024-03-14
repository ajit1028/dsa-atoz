// 1- PreOrder Recursion
class Solution {
    public void preorderTraversal_(TreeNode root, List<Integer>  ans)
    {
        if(root == null) return ;

       
        inorderTraversal_(root.left,ans);
        ans.add(root.val);
        inorderTraversal_(root.right,ans);


    }

    public List<Integer> inorderTraversal(TreeNode root) {
      
     List<Integer> ans = new ArrayList<>();
       inorderTraversal_(root,ans);
       return ans;

    }
}


//2- PreOrder Morris
class Solution {

    public TreeNode getRightMostNode(TreeNode node, TreeNode curr)
    {
        while(node.right!=null && node.right != curr)
        {
            node = node.right;
        }
        return node;
    }


    public void morrisInorder(TreeNode root, List<Integer>  ans)
    {
        TreeNode curr = root;
        while(curr!=null)
        {
            TreeNode left = curr.left;
            if(left == null)
            {
                ans.add(curr.val);
                curr = curr.right;
            }

            else
            {
                TreeNode rightMostNode = getRightMostNode(left,curr);

                if(rightMostNode.right == null)
                {
                    //thread Creation
                    rightMostNode.right = curr;
                    
                    curr = curr.left;
                } 
                else
                {
                    //thread destroy
                    rightMostNode.right = null;
                    ans.add(curr.val);
                    curr=curr.right;
                }
            }

        }
        


    }

   
    
    
    
   public List<Integer> inorderTraversal(TreeNode root) {
     List<Integer> ans=new ArrayList<>();
     morrisInorder(root,ans);
     return ans; 
    }

}