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
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int left =leftheight(root.left);
        int right =rightheight(root.right);
        if(left==right){
            return  ((2<<left)-1);
        }
        return 1+countNodes(root.left)+countNodes(root.right);
    }
    public static int leftheight(TreeNode root){
        if(root==null) return 0;
        return 1+leftheight(root.left);
    }
    public static int rightheight(TreeNode root){
        if(root==null) return 0;
        return 1+rightheight(root.right);
    }
}