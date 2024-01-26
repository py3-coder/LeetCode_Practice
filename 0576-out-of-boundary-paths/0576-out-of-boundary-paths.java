class Solution {
    static int mod = (int)1e9+7;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        Integer[][][] dp = new Integer[maxMove+1][m][n];
        return dfs(startRow,startColumn,maxMove,m,n,dp);
    }
    public static int dfs(int row,int col ,int moves ,int m,int n,Integer[][][] dp){
        if(row<0 || row>=m || col<0 || col>=n){
            return 1;
        }
        if(moves==0) return 0;
         if(dp[moves][row][col]!=null) return dp[moves][row][col];
        int[] drow ={-1,0,1,0};
        int[] dcol ={0,1,0,-1};
        int res =0;
        for(int i=0;i<4;i++){
            int nrow = row+drow[i];
            int ncol = col+dcol[i];
            res =(res+dfs(nrow,ncol,moves-1,m,n,dp))%mod;
        }
        
        return dp[moves][row][col]=res; 
    }
}
