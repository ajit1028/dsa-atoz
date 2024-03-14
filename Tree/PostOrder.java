class Solution {
    public void postorder(TreeNode root,List<Integer> list)
    {
        if(root == null) return ;
        
        postorder(root.left,list);
        postorder(root.right,list);
         list.add(root.val);
        
        
    }
  
   
   
   
  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> list=new ArrayList<>();
    postorder(root,list);
    return list; 
   }
}