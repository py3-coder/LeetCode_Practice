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
    public boolean is_ValidBST(TreeNode root,long minval,long maxval){
        if(root==null) return true;
        if(root.val>=maxval || root.val<=minval) return false;
        return is_ValidBST(root.left,minval,root.val) &&                    is_ValidBST(root.right,root.val,maxval);
    }
    public boolean isValidBST(TreeNode root) {
        return is_ValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
}