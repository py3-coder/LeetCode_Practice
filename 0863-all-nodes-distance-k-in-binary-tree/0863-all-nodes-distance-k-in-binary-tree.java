/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        Set<TreeNode> vis = new HashSet<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            TreeNode curr = que.poll();
            if(curr == target) break;
            if(curr.left!=null){
                map.put(curr.left,curr);
                que.add(curr.left);
            }
            if(curr.right!=null){
                map.put(curr.right,curr);
                que.add(curr.right);
            }
        }
        //System.out.println(map);
        que.clear();
        que.add(target);
        vis.add(target);
        while(k-->0){
            if(que.isEmpty()) return new ArrayList<>();
            for(int i=que.size();i>0;i--){
                TreeNode curr = que.poll();
                if(curr.left!=null && vis.add(curr.left))  que.add(curr.left);
                if(curr.right!=null && vis.add(curr.right))  que.add(curr.right);
                if(map.get(curr)!=null && vis.add(map.get(curr))) que.add(map.get(curr));   
            }
        } 
        while(!que.isEmpty()){
            res.add(que.poll().val);
        }
        return res;
    }
}