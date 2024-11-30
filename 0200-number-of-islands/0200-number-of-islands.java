class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length , m = grid[0].length;
        int cnt =0;
        int[][] vis = new int[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && vis[i][j]!=1){
                    cnt++;
                    dfs(i,j,grid,vis);
                }
            }
        }
        return cnt;
        
        
        
    }
    public void dfs(int x , int y, char[][] grid, int[][] vis){
        int n = grid.length , m = grid[0].length;
        int[] dx ={0,-1,0,1};
        int[] dy ={1,0,-1,0};
        vis[x][y]=1;
        for(int i=0;i<4;i++){
            int nx =x+dx[i];
            int ny =y+dy[i];
            
            if(nx>=0 && ny>=0 && nx<n && ny<m && grid[nx][ny]!='0' && vis[nx][ny]!=1){
                dfs(nx,ny,grid,vis);
            }
        }
        
    }
}