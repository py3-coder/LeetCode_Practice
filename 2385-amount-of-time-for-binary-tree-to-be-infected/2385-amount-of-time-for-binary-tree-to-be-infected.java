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
    static TreeNode temp1;
    public int amountOfTime(TreeNode root, int start) {
        // Lets Play ::)
        // Lets make adj list ::
        HashMap<TreeNode,TreeNode> map =new HashMap<>();
        TreeNode temp =root;
        map.put(root,null);
        temp1=null;
        traversal(map ,root,root,start);
        
        int[] vis =new int[100001];
        Queue<Pair> que =new LinkedList<>();
        que.offer(new Pair(temp1,0));
        vis[temp1.val]=1;
        int cnt=0;
        while(!que.isEmpty()){
            Pair curr = que.poll();
            TreeNode node = curr.node;
            cnt =Math.max(cnt,curr.steps);
            TreeNode left =node.left;
            TreeNode right =node.right;
            if(left!=null && vis[left.val]!=1 ){
                que.offer(new Pair(left,(curr.steps+1)));
                vis[left.val]=1;
            }
            if(right!=null && vis[right.val]!=1 ){
                que.offer(new Pair(right,(curr.steps+1)));
                vis[right.val]=1;
            }
            TreeNode par =map.get(node);
            if(par!=null && vis[par.val]!=1 ){
                que.offer(new Pair(par,(curr.steps+1)));
                vis[par.val]=1;
            }
            
        } 
        return cnt;
        
    }
    public static void traversal(HashMap<TreeNode,TreeNode> map,TreeNode root,TreeNode prev,int start){
        if(root==null) return;
        
        if(root.val == start){
            temp1 =root;
        }
        if(root != prev){
            map.put(root,prev);
            prev =root;
        }
        traversal(map,root.left,prev,start);
        traversal(map,root.right,prev,start);   
    }
    class Pair{
        TreeNode node;
        int steps;
        
        Pair(TreeNode _node,int _steps){
            this.node =_node;
            this.steps =_steps;
        }
    }
}