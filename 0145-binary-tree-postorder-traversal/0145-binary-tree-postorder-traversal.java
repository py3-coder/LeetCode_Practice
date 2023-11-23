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
//         if(root==null) return res;
        
//         Stack<TreeNode> st =new Stack<>();
//         Stack<TreeNode> st1 =new Stack<>();
//         st.push(root);
        
//         while(!st.isEmpty()){
//             root =st.pop();
//             st1.push(root);
//             if(root.left!=null){
//                 st.push(root.left);
//             }
//             if(root.right!=null){
//                 st.push(root.right);
//             }
//         }
//         while(!st1.isEmpty()){
//             root =st1.pop();
//             res.add(root.val);
//         }
//         return res;
        
        //Using Single Stack ::Iterative ::
        
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr =root;
        while(!st.isEmpty() || curr!=null){
            if(curr!=null){
                st.push(curr);
                curr=curr.left;
            }else{
                 TreeNode temp=st.peek();
                 temp=temp.right;
                if(temp==null){
                    temp =st.peek();
                    st.pop();
                    res.add(temp.val);
                    while(!st.isEmpty() && temp==st.peek().right){
                        temp =st.pop();
                        res.add(temp.val);
                    }
                }else{
                    curr=temp;
                }
            }
        }
        return res;
        
        
    }
}