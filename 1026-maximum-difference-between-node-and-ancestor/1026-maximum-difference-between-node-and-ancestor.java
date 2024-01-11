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
    static int maxi;
    public int maxAncestorDiff(TreeNode root) {
        if(root==null) return 0;
        maxi=0;
        List<List<Integer>> paths =new ArrayList<>();
        path(root,paths,new ArrayList<>());
        return maxi;
        
    }
    public static void path(TreeNode root,List<List<Integer>> paths ,List<Integer> temp){
        //Base Case ::
        if(root==null){
            return;
        }
        temp.add(root.val);
        if(root.left == null && root.right==null){
            // temp -- list of each path :)
            for(int i=0;i<temp.size();i++){
                for(int j=i+1;j<temp.size();j++){
                    int val =Math.abs(temp.get(i)-temp.get(j));
                    maxi =Math.max(val,maxi);
                }
            }
        }
        path(root.left,paths,temp);
        path(root.right,paths,temp);
        temp.remove(temp.size()-1);
    }
}