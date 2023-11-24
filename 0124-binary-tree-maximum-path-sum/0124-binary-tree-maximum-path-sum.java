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
    public int maxPathSum(TreeNode root) {
        if(root==null) return 0;
        sum=Integer.MIN_VALUE;
        solveSum(root);
        return sum;
        
    }
    public static int solveSum(TreeNode root){
        //Base Case::
        if(root==null) return 0;
        
        int left =Math.max(0,solveSum(root.left));
        int right=Math.max(0,solveSum(root.right));
        
        sum =Math.max(sum,left+right+root.val);
        return Math.max(left,right)+root.val;
    }
}