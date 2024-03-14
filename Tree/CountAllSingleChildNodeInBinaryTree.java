class Tree
{
    public void exactlyOneChild(Node root, ArrayList<Integer> ans)
    {
        if(root == null || (root.left == null && root.right == null)) return;
        
        if(root.left == null || root.right == null)
        {
            ans.add(root.data);
        }
        
        exactlyOneChild(root.left,ans);
        exactlyOneChild(root.right,ans);
    }
    
    ArrayList<Integer> exactlyOneChild(Node node)
    {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        exactlyOneChild(node,ans);
        return ans;
    }
}

//count all single child parent 
class Tree
{
    public void countExactlyOneChild(Node root)
    {
        int ans = 0;

        if(root == null || (root.left == null && root.right == null)) return 0;
        
        int leftChildCount = countExactlyOneChild(root.left);
        int rightChildCount = countExactlyOneChild(root.right);
        int ans = leftChildCount + rightChildCount ;
        if(root.left == null || root.right == null)
        {
            ans++;
        }
        
        
       return ans;
    }
    
   
}



//find all the lonely nodes
class Solution {
    private List<Integer> ans = new ArrayList<>();

    public List<Integer> getLonelyNodes(TreeNode root) {
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        if (root.left == null) {
            ans.add(root.right.val);
        }
        if (root.right == null) {
            ans.add(root.left.val);
        }
        dfs(root.left);
        dfs(root.right);
    }
}