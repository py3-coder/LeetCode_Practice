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
    /*
    Think of range kind of think evey node have some range in BST
    for root node it must lies btwn [-Int.Min , +Int.Max]
    similary as we got to left the uperbound is bounded by root
    and as we go to right the lower bound is get bounded by root.
    */
    public TreeNode bst_Pre(int[] pre ,int Ubound,int[] i){
        if(i[0]==pre.length || pre[i[0]]>Ubound) return null;
        TreeNode root  = new TreeNode(pre[i[0]++]);
        root.left = bst_Pre(pre,root.val,i);
        root.right = bst_Pre(pre,Ubound,i);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return bst_Pre(preorder,Integer.MAX_VALUE,new int[]{0});
    }
}