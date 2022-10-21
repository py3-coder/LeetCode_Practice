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
    TreeNode node;
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        boolean left,right;
        left = isValidBST(root.left);
        //System.out.println(root.val);
        if(node !=null && node.val>=root.val) return false;
        node =root;
        right = isValidBST(root.right);
        return left&&right;
    }
}