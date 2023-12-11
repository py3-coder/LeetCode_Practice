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
        HashMap<Integer,Integer> map  = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        
        int prestart=0,preend=preorder.length-1;
        int instart=0,inend=inorder.length-1;
        TreeNode root =build(0,preorder.length-1,preorder,0,inorder.length-1,inorder,map);
        return root;
        
    }
    public static TreeNode build(int prestart,int preend,int[] preorder ,int instart,int inend,int[] inorder,HashMap<Integer,Integer> map){
        if(prestart>preend || instart>inend) return null;
        
        TreeNode root =new TreeNode(preorder[prestart]);
        int inRoot =map.get(root.val);
        int numleft =inRoot-instart;
        
        root.left =build(prestart+1,prestart+numleft,preorder,instart,inRoot-1,inorder,map);
        root.right =build(prestart+numleft+1,preend,preorder,inRoot+1,inend,inorder,map);
        
        return root;
        
    }
}