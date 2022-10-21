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
    public void bfs(TreeNode root , List<List<Integer>> res,int len){
        if(root==null) return;
        if(len>=res.size()){
            res.add(new ArrayList<Integer>());
        }
        res.get(len).add(root.val);
        bfs(root.left,res,len+1);
        bfs(root.right,res,len+1);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        bfs(root,res,0);
        return res;
    }
}