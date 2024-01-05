class Solution {
    static int[][] dp =new int[101][101];
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int x=obstacleGrid.length;
        int y=obstacleGrid[0].length;
        if(obstacleGrid[x-1][y-1]==1){
            return 0;
        }
        Arrays.stream(dp).forEach(a->Arrays.fill(a,-1));
        return solveRec(obstacleGrid,x-1,y-1);
    }
    public static int solveRec(int[][] obs,int x,int y){
        if(x==0 && y==0) return 1;
        if(x<0 || y<0) return 0;

        if(dp[x][y]!=-1){
            return dp[x][y];
        }
        //left 
        int way1=0,way2=0;
        if(y>0 && obs[x][y-1]!=1){
            way1=solveRec(obs,x,y-1);
        }
        //up
        if(x>0 && obs[x-1][y]!=1){
            way2=solveRec(obs,x-1,y);
        }
        return dp[x][y]=way1+way2;
    }
}