class Solution {
    public boolean canFinish(int nC, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<nC;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] pre : prerequisites){
            adj.get(pre[1]).add(pre[0]);
        }
        int[] vis = new int[nC];
        for(int i=0;i<nC;i++){
            if(vis[i]==0){
                if (dfs(i, vis, adj)) {
                return false;
                }
            }
            
        }
        return true;
        
    }
    public boolean dfs(int node , int[] vis ,ArrayList<ArrayList<Integer>> adj){
        vis[node]=1;
        for(int adjNode : adj.get(node)){
            if(vis[adjNode]==0){
                if(dfs(adjNode,vis,adj)){
                    return true;
                }
            }else if(vis[adjNode]==1){
                return true;
            }
        }
        vis[node]=2;
        return false;
    }
    
}