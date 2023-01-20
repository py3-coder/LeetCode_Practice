/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        int curr = root.val;
        // when p and q both are greater than root..
        // so we will get lca on right side...
        if(curr<p.val && curr<q.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        // when p and q both are lesser than root..
        // so we will get lca on left side...
        if(curr>p.val && curr>q.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        // if p & q are in opp. side then in that case root will LCA...
        return root;
    }
}