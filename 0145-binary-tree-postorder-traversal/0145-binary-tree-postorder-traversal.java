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
    public List<Integer> postorderTraversal(TreeNode root) {
        //1. Recursion :
        
        
        //2. Iterative - 2 stack ::
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        
        Stack<TreeNode> st =new Stack<>();
        Stack<TreeNode> st1 =new Stack<>();
        st.push(root);
        
        while(!st.isEmpty()){
            root =st.pop();
            st1.push(root);
            if(root.left!=null){
                st.push(root.left);
            }
            if(root.right!=null){
                st.push(root.right);
            }
        }
        while(!st1.isEmpty()){
            root =st1.pop();
            res.add(root.val);
        }
        return res;
        
    }
}