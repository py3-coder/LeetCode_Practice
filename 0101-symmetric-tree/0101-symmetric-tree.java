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
    public boolean isSymmetric(TreeNode root) {
        if(root.left ==null && root.right==null) return true;
        if(root.left ==null || root.right==null) return false;
        
        Queue<TreeNode> que = new LinkedList<>();
        
        que.offer(root.left);
        que.offer(root.right);
        
        while(que.size()>0){
            TreeNode first =que.poll();
            TreeNode sec =que.poll();
            if (first == null && sec == null) continue;
            if (first == null || sec == null) return false;
            if(first.val !=sec.val) return false;
                que.offer(first.left);
                que.offer(sec.right);
                que.offer(first.right);
                que.offer(sec.left);
            
        }
        return true;
    }
}