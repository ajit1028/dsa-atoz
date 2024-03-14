class Solution {
    public static void rootToLeafPath(Node root, ArrayList<ArrayList<Integer>> ans,ArrayList<Integer>smallAns)
    {
        if(root == null) return;
        
        if(root.left == null && root.right == null)
        {
            ArrayList<Integer> base = new ArrayList<>(smallAns);
            base.add(root.data);
            ans.add(base);
        }
        
        smallAns.add(root.data);
         rootToLeafPath(root.left,ans,smallAns);
          rootToLeafPath(root.right,ans,smallAns);
          
          smallAns.remove(smallAns.size()-1);
        
    }
    
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer>smallAns = new ArrayList<>();
         rootToLeafPath(root,ans,smallAns);
         return ans;
    }
}