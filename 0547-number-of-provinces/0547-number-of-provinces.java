class Solution {
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = isConnected.length;
        int m =isConnected[0].length;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i!=j && isConnected[i][j]==1){
                    adj.get(i).add(j);
                    //adj.get(j).add(i);
                }
            }
        }
        int[] vis = new int[n+1];
        int cnt=0;
        for(int i=0;i<n;i++){
            if(vis[i]!=1){
                dfs(i,vis,adj);
                cnt++;
            }
        }
        //System.out.println(adj);
        return cnt;
    }
    public void dfs(int node,int[] vis,ArrayList<ArrayList<Integer>> adj){
        vis[node]=1;
        
        for(int nodes : adj.get(node)){
            if(vis[nodes]!=1){
                dfs(nodes,vis,adj);
            }
        }
    }
}