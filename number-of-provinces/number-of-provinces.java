class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1 && i!=j){
                   adj.get(i).add(j);
                   adj.get(j).add(i);
                }
            }
        }
        int cnt=0;
        int[] vis = new int[n];
        for(int i=0;i<n;i++){
            if(vis[i]!=1){
                cnt++;
                dfs(i,vis,adj);
            }
        }
        return cnt;
    }
    public void dfs(int node,int[] vis,List<List<Integer>> adj){
        vis[node]=1;
        for(int currNode :adj.get(node)){
            if(vis[currNode]!=1){
                dfs(currNode,vis,adj);
            }
        }
    }
}