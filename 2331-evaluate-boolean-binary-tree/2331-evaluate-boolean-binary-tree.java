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
    public boolean evaluateTree(TreeNode root) {
        return play(root);
    }
    
    public boolean solve(TreeNode root){
        if(root.left==null && root.right==null){
            if(root.val==0){
                return false;
            }else{
                return true;
            }
        }

        return (root.val==3)?(solve(root.left) && solve(root.right)):(solve(root.left) || solve(root.right));
        
    }
    public boolean play(TreeNode root){        
       return (root.val < 2) ? (root.val != 0) : (root.val == 2) ? (play(root.left) || play(root.right)) : (play(root.left) && play(root.right));
    }
}
