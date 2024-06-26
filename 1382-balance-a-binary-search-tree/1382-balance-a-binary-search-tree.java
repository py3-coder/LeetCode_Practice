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
    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> temp = new ArrayList<>();
        inOrder(root,temp);
        return constructBTree(0,temp.size()-1 ,temp);
    }
    public TreeNode constructBTree(int start ,int end , List<TreeNode> temp){
        if(start>end) return null;
        int m = (start+end)/2;
        TreeNode root = temp.get(m);
        root.left = constructBTree(start , m-1 , temp);
        root.right = constructBTree(m+1 , end , temp);
        return root;
        
    }
    public void inOrder(TreeNode root , List<TreeNode> res){
        if(root == null) return  ;
        inOrder(root.left , res) ;
        res.add(root);
        inOrder(root.right, res) ;
    }
}