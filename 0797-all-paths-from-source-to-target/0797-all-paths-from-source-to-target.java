class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> res =new ArrayList<>();
        List<Integer> temp =new ArrayList<>();
        temp.add(0);
        int[] vis =new int[n];
        dfs(0,vis,graph,temp,res);
        return res;
    }
    public void dfs(int node,int[] vis,int[][] graph,List<Integer> temp,List<List<Integer>> res){
        if (node == graph.length - 1) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        for(int currNode : graph[node]){
            if(vis[currNode]!=1){
                temp.add(currNode);
                dfs(currNode,vis,graph,temp,res);
                temp.remove(temp.size()-1);
            }
        }   
    }
}