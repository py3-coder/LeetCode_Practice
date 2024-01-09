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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> temp1 =new ArrayList<>();
        List<Integer> temp2 =new ArrayList<>();
        
        leafNode(root1,temp1);
        leafNode(root2,temp2);
        if(temp1.size()!=temp2.size()) return false;
        for(int i=0;i<temp1.size();i++){
            //System.out.println(temp1.get(i)+":"+temp2.get(i));
            if(temp1.get(i)!=temp2.get(i)){
                return false;
            }
        }
        return true;
    }
    public static void leafNode (TreeNode root,List<Integer> temp){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            temp.add(root.val);
        }
        else{
            leafNode(root.left,temp);
            leafNode(root.right,temp);
        }
    }
}