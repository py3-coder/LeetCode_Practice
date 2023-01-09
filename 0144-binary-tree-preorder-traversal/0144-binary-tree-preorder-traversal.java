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
    //Recurisive Soln:
    //PreOrder - Root Left Right...
    public List<Integer> solveR(TreeNode root,List<Integer> res){
        if(root ==null)  return res; //Base Case
        // Add root to list
        res.add(root.val);
        // Left Recursive call
        solveR(root.left,res);
        //Right Recursive call
        solveR(root.right,res);
        
        //retturn list after all call finished
        return res;
    }
    
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        return solveR(root, res);
        
    }
}