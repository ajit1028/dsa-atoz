/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Method - Space Taking
class Solution {
      boolean nodeToRootPath_(TreeNode root, int data, ArrayList<TreeNode> path) {

      if (root == null)
          return false;

      if (root.val == data) {
          path.add(root);
          return true;
      }


      boolean res = nodeToRootPath_(root.left, data, path) || nodeToRootPath_(root.right, data, path);

      if (res)
          path.add(root);
      return res;
  }
    
    public void kdown(TreeNode root, int k, TreeNode block, List<Integer> ans) {
    if (root == null || k < 0 || root == block)
        return;

    if (k == 0) {
        ans.add(root.val);
        return;
    }

    kdown(root.left, k - 1, block, ans);
    kdown(root.right, k - 1, block, ans);
}



public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

    ArrayList<TreeNode> path = new ArrayList<>();
    nodeToRootPath_(root, target.val, path);

    List<Integer> ans = new ArrayList<>();
    TreeNode block = null;
    for (int i = 0; i < path.size(); i++) {
        kdown(path.get(i), k - i, block, ans);
        block = path.get(i);
    }
    return ans;
    
}
}


//method-2 without space

class Solution {
    public void kdown(TreeNode root, int k, TreeNode block, List<Integer> ans) {
    if (root == null || k < 0 || root == block)
        return;

    if (k == 0) {
        ans.add(root.val);
        return;
    }

    kdown(root.left, k - 1, block, ans);
    kdown(root.right, k - 1, block, ans);
}
 //method 2 all nodes distance K in Binary tree(without space)
public int distanceK(TreeNode root, TreeNode target, int k, List<Integer> ans) {
    if (root == null)
        return -1;

    if (root == target) {
        kdown(root, k, null, ans);
        return 1;
    }

    int ld = distanceK(root.left, target, k, ans);
    if (ld != -1) {
        kdown(root, k - ld, root.left, ans);
        return ld + 1;
    }

    int rd = distanceK(root.right, target, k, ans);
    if (rd != -1) {
        kdown(root, k - rd, root.right, ans);
        return rd + 1;
    }

    return -1;
}
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

   

    List<Integer> ans = new ArrayList<>();
    distanceK(root,target,k,ans);
    return ans;
}
}