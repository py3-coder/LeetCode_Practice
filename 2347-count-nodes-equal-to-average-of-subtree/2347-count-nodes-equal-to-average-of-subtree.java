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
    static int count;
    static class Pair{
        int valR;
        int cnt;
        Pair(int _val,int _cnt){
            this.valR =_val;
            this.cnt=_cnt;
        }
    }
    public static Pair solveRec(TreeNode root){
        if(root == null) return new Pair(0,0);
        Pair left =solveRec(root.left);
        Pair right =solveRec(root.right);
        int tot_sum=left.valR+right.valR+root.val;
        int tot_nodes=left.cnt+right.cnt+1;
        if(tot_sum/tot_nodes==root.val) count++;
        return new Pair(left.valR+right.valR+root.val,left.cnt+right.cnt+1);
    }
    public int averageOfSubtree(TreeNode root) {
        count=0;
        solveRec(root);
        int temp =count;
        count=0;
        return temp;
    }
}