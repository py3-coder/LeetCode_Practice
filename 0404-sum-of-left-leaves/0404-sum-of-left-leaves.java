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
    public int sum(TreeNode root, boolean isleft){
        if(root==null) return 0;
        if(root.left==null && root.right==null && isleft==true){
            return root.val;
        }
        return sum(root.left,true)+sum(root.right,false);
    }
    public int sumOfLeftLeaves(TreeNode root) {
     if(root==null) return 0;
     return sum(root.left,true)+sum(root.right,false);
    }
   
}