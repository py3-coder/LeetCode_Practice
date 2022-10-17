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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        TreeNode root =build(postorder,0,postorder.length-1,inorder,0,inorder.length-1,map);
        return root;
    }
    public TreeNode build(int[] postorder,int ps,int pe,int[] inorder,int is,int ie,HashMap<Integer,Integer> map){
        if(is>ie || ps>pe) return null;
        TreeNode root = new TreeNode(postorder[pe]);
        
        int inRoot =map.get(postorder[pe]);
        int nums =inRoot-is;
        root.left =build(postorder,ps,ps+nums-1,inorder,is,inRoot-1,map);
        root.right=build(postorder,ps+nums,pe-1,inorder,inRoot+1,ie,map);
         
        return root;
    }
}