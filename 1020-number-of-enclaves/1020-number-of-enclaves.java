class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int[][] vis = new int[n][m];
        
        // Topleft->right
        for(int i=0;i<m;i++){
            if(grid[0][i]==1 && vis[0][i]!=1){
                dfs(0,i,vis,grid);
            }
        }
        //Topleft -> bottom left
        for(int i=1;i<n;i++){
            if(grid[i][0]==1 && vis[i][0]!=1){
                dfs(i,0,vis,grid);
            }
        }
        // bootom left -> bottom right
        for(int i=0;i<m;i++){
            if(grid[n-1][i]==1 && vis[n-1][i]!=1){
                dfs(n-1,i,vis,grid);
            }
        }
        
        // Top right -> bottom right
        for(int i=0;i<n;i++){
            if(grid[i][m-1]==1 && vis[i][m-1]!=1){
                dfs(i,m-1,vis,grid);
            }
        }
        
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]!=1 && grid[i][j]==1 ){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    
    public void dfs(int row,int col ,int[][] vis,int[][] grid){
        vis[row][col]=1;
        
        int[] dx ={1,0,-1,0};
        int[] dy ={0,1,0,-1};
        
        for(int i=0;i<4;i++){
            int nr =row+dx[i];
            int nc =col+dy[i];
            
            if(nr<grid.length && nr>=0 && nc<grid[0].length && nc>=0 && grid[nr][nc]==1 && vis[nr][nc]!=1){
                dfs(nr,nc,vis,grid);
            }
        }
    }
}