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
    //Can be done using Post-order traversion :)
    public String tree2str(TreeNode root) {
        if(root==null) return "";
        
        String l  =tree2str(root.left);
        String r  =tree2str(root.right);
        
        return Integer.toString(root.val)+combine(l,r);
    }
    public static String combine(String l ,String r){
        if(l=="" && r=="") return "";
        if(l!="" && r=="") return '('+l+')';
        if(l=="" && r!="") return "()"+'('+r+')';
        return '('+l+')'+'('+r+')';
    }
}