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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        boolean flag =false;
        while(!que.isEmpty()){
            int len = que.size();
           LinkedList<Integer> subres = new LinkedList<>();
            for(int i=0;i<len;i++){
                TreeNode node = que.poll();
                if(node.left!=null) que.offer(node.left);
                if(node.right!=null) que.offer(node.right);
                if(flag) subres.addFirst(node.val);
                else  subres.addLast(node.val);
            }
            flag =!flag;
            res.add(subres);
        }
        return res;
    }
}