class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[]  road =new int[n];
        int[][] vis = new int[n][n];
        
        for(int i=0;i<roads.length;i++){
            road[roads[i][0]]++;
            road[roads[i][1]]++;
            vis[roads[i][0]][roads[i][1]]=1;
            vis[roads[i][1]][roads[i][0]]=1;
           
        }
        
        int res = 0;
        for (int i = 0; i < n; i++) 
            for (int j = i + 1; j < n; j++) 
                res = Math.max(res, road[i] + road[j] - vis[i][j]);
        return res;
        
    }
}