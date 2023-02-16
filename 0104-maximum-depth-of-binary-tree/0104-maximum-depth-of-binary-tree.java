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
    public int depth(TreeNode root){
        if(root == null) return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        
        return 1+Math.max(left,right);
    }
    public int maxDepth(TreeNode root) {
        return depth(root);
    }
}