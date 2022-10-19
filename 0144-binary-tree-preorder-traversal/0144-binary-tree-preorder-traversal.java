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
    public List<Integer> solveR(TreeNode root,List<Integer> res){
        if(root == null) return res;
        res.add(root.val);
        solveR(root.left,res);
        solveR(root.right,res);
        
        return res;
    }
    
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> st = new Stack<>();
        Stack<TreeNode> st2 = new Stack
        st.push(root);
        while(!st.isEmpty()){
            root =st.pop();
            res.add(root.val);
            if(root.right !=null){
                st.push(root.right);
            }
            if(root.left!=null){
                st.push(root.left);
            }
        }
        return res;
    }
    */
    // Morris Traversal Practise
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> pre = new ArrayList<>();
        TreeNode curr = root;
        while(curr!=null){
            if(curr.left==null){
                pre.add(curr.val);
                curr =curr.right;
            }else{
                TreeNode prev = curr.left;
                while(prev.right!=null && prev.right!=curr){
                    prev=prev.right;
                }
                if(prev.right==null){
                    prev.right =curr;
                    pre.add(curr.val);
                    curr =curr.left;
                }else{
                    prev.right =null;
                    curr =curr.right;
                }
            }
        }
        return pre;
    }
}