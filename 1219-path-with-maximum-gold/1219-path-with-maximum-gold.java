class Solution {
    static int sum,res;
    public int getMaximumGold(int[][] grid) {
        // Simple DFS::
        int n  = grid.length;
        int m = grid[0].length;
        
        res = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]>0){
                    int[][] vis = new int[n][m];
                    sum =0;
                    dfs(i,j,vis,grid);
                }
            }
        }
        return res==Integer.MIN_VALUE?0:res;
    }
    public void dfs(int r,int c,int[][] vis,int[][] grid){
        
        sum+=grid[r][c];
        vis[r][c]=1;
        int[] dx= {0,1,0,-1};
        int[] dy= {1,0,-1,0};
        
        
        for(int k=0;k<4;k++){
            int nr = dx[k]+r;
            int nc = dy[k]+c;
            
            if(valid(nr,nc,grid.length,grid[0].length) && grid[nr][nc]>0 && vis[nr][nc]!=1){
                 dfs(nr,nc,vis,grid);
            }
        }
        res = Math.max(res,sum);
        sum-=grid[r][c];
        vis[r][c]=0;
        
        return ;
    }
    
    public boolean valid(int r,int c,int n,int m){
        return (r>=0 && r<n && c>=0 && c<m); 
    }
}