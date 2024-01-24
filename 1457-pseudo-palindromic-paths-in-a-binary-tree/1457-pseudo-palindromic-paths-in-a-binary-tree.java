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
    public int pseudoPalindromicPaths (TreeNode root) {
        // List<List<Integer>> res = new ArrayList<>();
        // List<Integer> temp =new ArrayList<>();
        // int cnt=0;
        // dfs(root,res,temp);
        // //System.out.println(res);
        // for(List<Integer> lis : res){
        //     if(checkPossiblePanlidrome(lis)){
        //         cnt++;
        //     }
        // }
        // return cnt;
        
        HashSet<Integer> set =new HashSet<>();
        return cntPalidromePossible(root,set);
    }
    public static int cntPalidromePossible(TreeNode root  , Set<Integer> set){
        //Base Case ::
        if(root == null) return 0;
        
        if(set.contains(root.val)){
            set.remove(root.val);
        }else{
            set.add(root.val);
        }
        
        if(root.left ==null && root.right ==null){
            return set.size()<=1?1:0;
        }
        int left=0,right=0;
        if(root.left!=null){
            left += cntPalidromePossible(root.left,new HashSet<>(set));
        }
        if(root.right!=null){
            right+=cntPalidromePossible(root.right,new HashSet<>(set));
        }
        return left+right;
    }
    
    // public static void dfs(TreeNode root ,List<List<Integer>> res ,List<Integer> temp){
    //     if(root==null) return;
    //     temp.add(root.val);
    //     if(root.left== null && root.right ==null){
    //         res.add(new ArrayList<>(temp));
    //         return;
    //     }
    //     if(root.left!=null) dfs(root.left,res,new ArrayList<Integer>(temp));
    //     if(root.right!=null) dfs(root.right,res,new ArrayList<Integer>(temp));
    // }
    // public static boolean checkPossiblePanlidrome(List<Integer> temp){
    //     int[] arr =new int[10];
    //     for(int ele:temp){
    //         arr[ele]++;
    //     }
    //     int cnt1=0;
    //     for(int i=1;i<10;i++){
    //        if(arr[i]>0 && arr[i]%2!=0){
    //             cnt1++;
    //             if(cnt1>1){
    //                 return false;
    //             }
    //         }
    //     }
    //     return true;
    // }
}