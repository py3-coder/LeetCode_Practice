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
    public int maxDepth(TreeNode root) {
        //1.Recursive ::
        //TC : O(n)
        //SC :O(1)+O(n) --aux space :-
        // return getheight(root);
        
        //Iterative ::
        //TC :O(n)
        //SC :O(n)
        return getHeight(root);
    }
    public static int getheight(TreeNode root){
        //base case ::
        if(root ==null) return 0;
        return 1+Math.max(getheight(root.left),getheight(root.right));
    }
    public static int getHeight(TreeNode root){
        
        if(root==null) return 0;
        int depth=1;
        Queue<TreeNode> qu =new ArrayDeque<>();
        qu.offer(root);
        while(!qu.isEmpty()){
            int size =qu.size();
            for(int i=0;i<size;i++){
                TreeNode temp =qu.poll();
                if(temp.left!=null){
                    qu.offer(temp.left);
                }
                if(temp.right!=null){
                    qu.offer(temp.right);
                }
            }
            if(qu.size()==0) return depth;
            depth++;
        }
        return depth;
    }
}