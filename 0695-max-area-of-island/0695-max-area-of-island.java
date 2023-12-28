class Solution {
    static int area;
    public int maxAreaOfIsland(int[][] grid) {
        
        int n =grid.length;
        int m =grid[0].length;
        int maxi=0;
        int[][] vis = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]!=1 && grid[i][j]==1){
                    area=0;
                    dfs(i,j,vis,grid);
                    maxi =Math.max(area,maxi);
                }
            }
        }
        return maxi;
    }
    public static void dfs(int row,int col,int[][] vis,int[][] grid){
        int n =grid.length;
        int m =grid[0].length;
        
        vis[row][col]=1;
        area++;
        int[] drow ={0,1,0,-1};
        int[] dcol ={1,0,-1,0};
        
        for(int i=0;i<4;i++){
            int nrow =row+drow[i];
            int ncol =col+dcol[i];
            
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]!=1 && grid[nrow][ncol]==1){
                 dfs(nrow,ncol,vis,grid);
            }
        }
    }
}