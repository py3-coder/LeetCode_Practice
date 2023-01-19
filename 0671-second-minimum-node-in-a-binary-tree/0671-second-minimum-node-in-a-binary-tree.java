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
    public List<Integer> inorder(TreeNode root,List<Integer> res){
        if(root==null) return null;
        inorder(root.left,res);
        res.add(root.val);
        inorder(root.right,res);
        
        return res;
    }
    public int findSecondMinimumValue(TreeNode root) {
        List<Integer> lis = new ArrayList<>();
        lis = inorder(root,lis);
        Collections.sort(lis);
        int num = lis.get(0);
        for(int val : lis){
            if(val>num){
                return val;
            }
        }
        return -1;
    }
}