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
    static TreeMap<Integer,TreeMap<Integer,List<Integer>>> map;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res =new ArrayList<>();
        map =new TreeMap<>();
        solveTree(0,0,root);
        for(int col:map.keySet()){
            List<Integer> sub =new ArrayList<>();
           for(List<Integer> lis :map.get(col).values()){
                Collections.sort(lis);
                sub.addAll(lis);
            }
            res.add(sub);
        }
        return res;
    }
    public static void solveTree(int x ,int y,TreeNode root){
        if(root==null){
            return;
        }
        map.putIfAbsent(x,new TreeMap<>());
        map.get(x).putIfAbsent(y,new ArrayList<>());
        map.get(x).get(y).add(root.val);
        solveTree(x-1,y+1,root.left);
        solveTree(x+1,y+1,root.right);
    }
}