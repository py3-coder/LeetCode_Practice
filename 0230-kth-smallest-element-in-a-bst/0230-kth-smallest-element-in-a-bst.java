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
    public int inorder(TreeNode root,int k){
        int count=0,ans=0;
        Stack<TreeNode> st = new Stack<>();
        while(!st.isEmpty()|| root!=null){
            while(root!=null){
                st.push(root);
                root =root.left;
            }
            root =st.pop();
            count++;
            if(count==k){
                ans=root.val;
            }
            //res.add(root.val)
            root =root.right;
        }
        return ans;
    }
    public int kthSmallest(TreeNode root, int k) {
        //List<Integer> res =new ArrayList<>();
        int ans = inorder(root,k);
        return ans;
    }
}