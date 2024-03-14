//  Pre Order 1->Normal recursion
class Solution {
    public void preorderTraversal_(TreeNode root, List<Integer>  ans)
    {
        if(root == null) return ;

        ans.add(root.val);
        preorderTraversal_(root.left,ans);
        preorderTraversal_(root.right,ans);


    }

    public List<Integer> preorderTraversal(TreeNode root) {
      
     List<Integer> ans = new ArrayList<>();
       preorderTraversal_(root,ans);
       return ans;

    }
}

//Pre Order 2->MORRIS PREORDER
class Solution {
    
    public TreeNode getRightMostNode(TreeNode node, TreeNode curr)
    {
        while(node.right!=null && node.right != curr)
        {
            node = node.right;
        }
        return node;
    }


    public void morrisPreorder(TreeNode root, List<Integer>  ans)
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
                     ans.add(curr.val);
                    curr = curr.left;
                } 
                else
                {
                    //thread destroy
                    rightMostNode.right = null;
                   
                    curr=curr.right;
                }
            }

        }
        


    }

    public List<Integer> preorderTraversal(TreeNode root) {
      
     List<Integer> ans = new ArrayList<>();
       morrisPreorder(root,ans);
       return ans;

    }
}