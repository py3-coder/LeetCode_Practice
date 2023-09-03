class Solution {
    public int solveR(int m,int n){
        if(m==0 && n==0) return 1;
        if(m<0 || n<0) return 0;
        int up = solveR(m-1,n);
        int left  = solveR(m,n-1);
        return up+left;
    }
    public int solveM(int m,int n,int dp[][]){
        if(m==0 && n==0) return 1;
        if(m<0 || n<0) return 0;
        if(dp[m][n] !=-1){
            return dp[m][n];
        }
        int up   =solveM(m-1,n,dp);
        int left =solveM(m,n-1,dp);
        dp[m][n]=up+left;
        return dp[m][n];
    }
    public int solveTab(int m,int n, int dp[][]){
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0 )  dp[i][j] =1;
                else{
                    int up=0,left=0;
                    if(i>0) up = dp[i-1][j];
                    if(j>0) left =dp[i][j-1];
                    dp[i][j] = up+left;
                }
            }
        }
        return dp[m-1][n-1];
    }
    public int solveSpaceOpt(int m,int n){
        int prev[] =new int[n];
        for(int i=0;i<m;i++){
            int curr[] =new int[n];
            for(int j=0;j<n;j++){
                if(i==0 && j==0) curr[i]=1;
                else{
                int up =0,left=0;
                if(i>0) up = prev[j];
                if(j>0) left =curr[j-1];
                curr[j] = up+left;
                }
            }
            prev = curr;
        }
        return prev[n-1];
    }
    public int uniquePaths(int m, int n) {
        //return solveR(m-1,n-1);
        //int dp[][] =new int[m][n];
        //Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        //return solveM(m-1,n-1,dp);
        //return solveTab(m,n,dp);
        return solveSpaceOpt(m,n);
    }
}