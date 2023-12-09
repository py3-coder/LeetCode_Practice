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
    
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res =new ArrayList<>();
        solve(0,root,res);
        return res;
    }
    
    public static void solve(int l,TreeNode root,List<Integer> res){
        if(root==null) return ;
        
        if(res.size()==l) res.add(root.val);
        
        solve(l+1,root.right,res);
        solve(l+1,root.left,res);
        
    }
}