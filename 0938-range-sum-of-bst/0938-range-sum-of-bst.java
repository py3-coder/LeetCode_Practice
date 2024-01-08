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
    static int sum;
    public int rangeSumBST(TreeNode root, int low, int high) {
        sum=0;
        inorder(root,low,high);
        return sum;
    }
    public static void inorder(TreeNode root,int low,int high){
        if(root==null) return ;
        
        if(root.val<=high && root.val>=low){
                sum+=root.val;
        }
        inorder(root.left,low,high);
        inorder(root.right,low,high);
        
    }
}