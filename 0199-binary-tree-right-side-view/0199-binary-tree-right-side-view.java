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
    public List<Integer> rightSideView(TreeNode root) {
        
        //edges ::
        if(root == null) return new ArrayList<>();
        List<Integer> lis = new ArrayList<>();
//         lis.add(root.val);
//         if(root.left == null && root.right==null) return lis;
//         rightView(root.right,lis);
//         return lis;
        
        List<List<Integer>> level  = levelorder(root);
        for(List<Integer> list : level ){
            lis.add(list.get(list.size()-1));
        }
        return lis;
    }
     
    public void rightView(TreeNode root, List<Integer> arr){
        if(root.left == null && root.right==null){
            arr.add(root.val);
            return;
        }
        if(root.right==null){
            rightView(root.left,arr);
        }
        arr.add(root.val);
        rightView(root.right,arr);
    }
    
    public List<List<Integer>> levelorder(TreeNode root){
        if(root == null) return new ArrayList<>();
        
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()){
            int size = que.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode re = que.poll();
               
                if(re.left!=null){
                    que.offer(re.left);
                }
                if(re.right!=null){
                    que.offer(re.right);
                }
                level.add(re.val);
            }
            res.add(level);
        }
        return res;
    }
    // public static List<List<Integer>> level(TreeNode root,List<List<Integer>> res) {
    //     if(root==null)  return res;
    //     Queue<TreeNode> que = new LinkedList<>();
    //     que.add(root);
    //     while(!que.isEmpty()){
    //         int level = que.size();
    //         List<Integer> ans  = new ArrayList<>();
    //         for(int i=0;i<level;i++){
    //             if(que.peek().left!=null)que.offer(que.peek().left);
    //             if(que.peek().right!=null)que.offer(que.peek().right);
    //             ans.add(que.poll().val);           
    //         }
    //         res.add(ans);
    //     } 
    //     return res;
    // }
}