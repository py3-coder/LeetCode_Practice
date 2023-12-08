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
class Pair{
    int data;
    TreeNode node;
    
    Pair(TreeNode _node,int _data){
        this.data=_data;
        this.node=_node;
    }
}
class Solution {
    //Level Order Traversal ::
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int ans=0;
        Queue<Pair> que =new LinkedList<>();
        que.offer(new Pair(root,0));
        while(!que.isEmpty()){
            int size=que.size();
            int min =que.peek().data;
            int f=0,l=0;
            for(int i=0;i<size;i++){
                int curr =que.peek().data-min;
                TreeNode node =que.poll().node;
                if(i==0) f=curr;
                if(i==size-1) l=curr;
                if(node.left!=null){
                    que.offer(new Pair(node.left,2*curr+1));
                }
                if(node.right!=null){
                    que.offer(new Pair(node.right,2*curr+2));
                }
            }
            ans =Math.max(ans,l-f+1);
        }
        return ans;
    }
}