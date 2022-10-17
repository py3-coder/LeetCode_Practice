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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        TreeNode root =build(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);
        return root;
    }
    public TreeNode build(int[] preorder,int prestart,int preend,int[] inorder,int instart,int inend,HashMap<Integer,Integer> map){
        if(prestart>preend || instart>inend) return null;
        TreeNode root = new TreeNode(preorder[prestart]);
        int inRoot =map.get(root.val);
        int numleft =inRoot-instart;
        
        root.left =build(preorder,prestart+1,prestart+numleft,inorder,instart,inRoot-1,map);
        root.right = build(preorder,prestart+numleft+1,preend,inorder,inRoot+1,inend,map);
        
        return root;
    }
}