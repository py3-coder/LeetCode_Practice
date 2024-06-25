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
    public TreeNode bstToGst(TreeNode root) {
        if(root == null) return root;
        inorder(root ,  0);
        return root;
        
    }
    public int inorder(TreeNode root , int s){
        if (root == null) {
            return 0;
        }
        int sum =  root.val + inorder(root.right, s);
        root.val = sum  + s;
        sum += inorder(root.left, root.val);
        return sum;   
    }
}