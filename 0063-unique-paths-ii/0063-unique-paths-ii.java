class Solution {
    static int[][] memo;
    public int uniquePathsWithObstacles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        memo = new int[n+1][m+1];
        Arrays.stream(memo).forEach(a->Arrays.fill(a,-1));
        if(grid[0][0]==1) return 0;
        return solveRec(0,0,n-1,m-1,grid);
    }
    public int solveRec(int r,int c,int n,int m,int[][] grid){
        //Base Case ::
        if(r == n && c == m){
            return 1;
        }
        if(r>n || c>m) return 0;
        
        
        if(memo[r][c]!=-1){
            return memo[r][c];
        }
        
        //right 
        int left=0,right=0;
        if(c+1<grid[0].length && grid[r][c+1]!=1){
            left+= solveRec(r,c+1,n,m,grid);
        }
        
        //down
        if(r+1<grid.length && grid[r+1][c]!=1){
            right+= solveRec(r+1,c,n,m,grid);
        }
        
        return memo[r][c]=left+right;
    }
}