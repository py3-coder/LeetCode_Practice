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
    public List<Integer> inorderTraversal(TreeNode root) {
       List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st =new Stack<>();
        while(!st.isEmpty() || root!=null){
                while(root!=null){
                    st.push(root);
                    root =root.left;
                }
                root =st.pop();
                res.add(root.val);
                root =root.right;
            }
        return res;
    }
    */
    // Practice -Morris Traversal
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> inorder = new ArrayList<>();
        TreeNode curr = root;
        while(curr!=null){
            // Case 1: When left is null;
            if(curr.left==null){
                // if left is null it means it a root so will go right after printing
                inorder.add(curr.val);
                curr = curr.right;
            }
            else{
                TreeNode prev= curr.left;
                // Going to right most node of tree of making thread connection just link it with root
                while(prev.right!=null && prev.right!=curr){
                    prev = prev.right;
                }
                // Right most left == null then we connected to root;
                if(prev.right==null){
                    prev.right = curr;
                    curr =curr.left;
                }
                // When we had already visted thr left it means we are root and we had visted the left part
                else{
                    prev.right =null;
                    // adding root to our list
                    inorder.add(curr.val);
                    // moving for right
                    curr =curr.right;
                }
            }
        }
        return inorder;
    }
}