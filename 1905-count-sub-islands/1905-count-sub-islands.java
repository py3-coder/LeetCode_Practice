class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length;
        int n = grid1[0].length;
        
        int cnt=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid2[i][j]==1 && grid1[i][j]==1){
                    if(dfs(grid1 ,grid2,i,j)){
                        cnt++;
                    }
                }
            }
        }
        return cnt;
        
    }
    public boolean dfs(int[][] grid1 , int[][] grid2 ,int i ,int j){
        if(i < 0 || i >= grid2.length || j < 0 || j >= grid2[0].length || grid2[i][j] == 0){
            return true;
        }
        if(grid1[i][j]!=grid2[i][j]){
            return false;
        }
        
        //marking vis
        grid2[i][j]=0;
        
        boolean left   = dfs(grid1,grid2,i-1,j);
        boolean right  = dfs(grid1,grid2,i+1,j);
        boolean top    = dfs(grid1,grid2,i,j+1);
        boolean bottom = dfs(grid1,grid2,i,j-1);
        
        return left && right && top && bottom ;
        
    }
}