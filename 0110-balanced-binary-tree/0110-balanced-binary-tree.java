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
    public boolean isBalanced(TreeNode root) {
        return check(root);
    }
    public static boolean check(TreeNode root){
        if(root == null) return true;
        int left =getheight(root.left);
        int right =getheight(root.right);
        if(Math.abs(left-right)<=1){
            return check(root.left) && check(root.right);
        }else{
            return false;
        }       
    }
    public static int getheight(TreeNode root){
        if(root==null) return 0;
        return 1+Math.max(getheight(root.left),getheight(root.right));
    }
}