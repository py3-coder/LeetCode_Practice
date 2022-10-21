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
    /*public void bfs(TreeNode root , List<List<Integer>> res,int len){
        if(root==null) return;
        if(len>=res.size()){
            res.add(new ArrayList<Integer>());
        }
        res.get(len).add(root.val);
        bfs(root.left,res,len+1);
        bfs(root.right,res,len+1);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        bfs(root,res,0);
        return res;
    }
    */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null)  return res;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            int level = que.size();
            List<Integer> ans  = new ArrayList<>();
            for(int i=0;i<level;i++){
                if(que.peek().left!=null)que.offer(que.peek().left);
                if(que.peek().right!=null)que.offer(que.peek().right);
                ans.add(que.poll().val);           
            }
            res.add(ans);
        } 
        return res;
    }
}