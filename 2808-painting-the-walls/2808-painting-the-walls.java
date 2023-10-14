class Solution {
    static int[][] memo = new int[501][501];
    public int paintWalls(int[] cost, int[] time) {
        int n=cost.length;
        //return solveRec(n,n,cost,time);
        Arrays.stream(memo).forEach(a->Arrays.fill(a,-1));
        return solveMemo(n,n,cost,time);
    }
    public static int solveRec(int n,int walls,int cost[],int time[]){
        //Base Case ::)
        if(walls<=0) return 0;
        if(n==0) return (int) (1e9);
        int pick =cost[n-1]+solveRec(n-1,walls-time[n-1]-1,cost,time);
        int notpick=solveRec(n-1,walls,cost,time);
        return Math.min(pick,notpick);
        
    }
    public static int solveMemo(int n,int walls,int cost[],int time[]){
        //Base Case ::)
        if(walls<=0) return 0;
        if(n==0) return (int) (1e9);
        if(memo[n][walls]!=-1){
            return memo[n][walls];
        }
        int pick =cost[n-1]+solveMemo(n-1,walls-time[n-1]-1,cost,time);
        int notpick=solveMemo(n-1,walls,cost,time);
        return memo[n][walls]=Math.min(pick,notpick);
        
    }
}