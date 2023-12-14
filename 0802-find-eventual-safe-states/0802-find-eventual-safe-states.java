class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n =graph.length;
        
        int[] vis = new int[n];
        int[] pathvis = new int[n];
        int[] check = new int[n];
        
        for(int i=0;i<n;i++){
            if(vis[i]!=1){
                dfs(i,vis,pathvis,graph,check);
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(check[i]==1){
                res.add(i);
            }
        }
        return res;
    }
    public static boolean dfs(int node,int[] vis,int[] pathvis,int[][] graph,int[] check){
        vis[node]=1;
        pathvis[node]=1;
        check[node]=0;
        
        for(int currNode : graph[node]){
            if(vis[currNode]!=1 && pathvis[currNode]!=1){
                if(dfs(currNode,vis,pathvis,graph,check)==true){
                    return true;
                }
            }else if(pathvis[currNode]==1){
                check[currNode]=0;
                return true;
            }
        }
        pathvis[node]=0;
        check[node]=1;
        return false;
    }
}