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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        if(p.val!=q.val) return false;
        Queue<TreeNode> que =new LinkedList<>();
        if(p!=null && q!=null){
            que.offer(p);
            que.offer(q);
        }
        
        while(!que.isEmpty()){
            TreeNode first = que.poll();
            TreeNode sec =que.poll();
            if(first==null && sec==null) continue;
            if(first==null || sec==null) return  false;
            if(first.val!=sec.val) return false;
            que.offer(first.left);
            que.offer(sec.left);
            que.offer(first.right);
            que.offer(sec.right);
        }
        return true;
    }
}