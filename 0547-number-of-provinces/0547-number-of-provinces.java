class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int m = isConnected[0].length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i!=j && isConnected[i][j]==1){
                    adj.get(i+1).add(j+1);
                    adj.get(j+1).add(i+1);
                }
            }
        }
        int cnt=0;
       // System.out.println(adj);
        int[] vis = new int[n+1];
        for(int i=1;i<=n;i++){
            if(vis[i]!=1){
                dfs(i,vis,adj);
                cnt++;
            }
        }
        return cnt;
        
        
    }
    public void dfs(int node , int[] vis , ArrayList<ArrayList<Integer>> adj){
        vis[node]=1;
        for(int curr :adj.get(node)){
           if(vis[curr]!=1){
               dfs(curr , vis , adj);
           }
        }
    }
}