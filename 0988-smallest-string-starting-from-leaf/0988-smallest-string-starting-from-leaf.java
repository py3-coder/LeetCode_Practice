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
    public String smallestFromLeaf(TreeNode root) {
        return smallStr(root,new StringBuilder()).toString();
    }
    StringBuilder smallStr(TreeNode root,StringBuilder sb){
        if(root==null){
            return sb;
        }
        sb.append((char)('a' + root.val));
        if(root.left==null && root.right==null){
            return sb.reverse();
        }
        StringBuilder sb1 = root.left != null ? smallStr(root.left,new StringBuilder(sb)):null;
        StringBuilder sb2 = root.right !=null ? smallStr(root.right,new StringBuilder(sb)):null;
        if(sb1!=null && sb2!=null){
            return sb1.toString().compareTo(sb2.toString())<0 ? sb1 : sb2;
        }else{
            return sb1!=null ? sb1 : sb2;
        }
    }
}