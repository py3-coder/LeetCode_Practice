class Solution {
    static int mod=1000000007;
    static int[][] memo= new int[31][1001];
    public int numRollsToTarget(int n, int k, int target) {
        //1.Recursion Solve::
        // TLE ::
        //return solveRec(n,k,target);

        //2. Memoisation:: 
        // TLE
        // Arrays.stream(memo).forEach(a->Arrays.fill(a,-1));
        // return solveMemo(n,k,target);

        //3. Tabulation:
        return solveTab(n,k,target);

        
    }
    public static int solveRec(int n,int k,int target){
        if(n==0 && target==0) return 1;
        int count=0;
        for(int i=k;i>0;i--){
            if(target-i<0){
                continue;
            }
            count+=solveRec(n-1,k,target-i);
            count%=mod;
        }
        return count;
    }
    public static int solveMemo(int n,int k,int target){
        if(n==0 && target==0) return 1;
        
        if(memo[n][target]!=-1){
            return memo[n][target];
        }
        int count=0;
        for(int i=k;i>0;i--){
            if(target-i<0){
                continue;
            }
            count+=solveRec(n-1,k,target-i);
            count%=mod;
        }
        return memo[n][target]=count;
    }
    public static int solveTab(int n,int k,int target){
        //Tabulation::
        int tab[][] = new int[n+1][target+1];
        //initilisation::
        tab[0][0]=1;
        for(int i=1;i<n+1;i++){
            for(int j=1;j<target+1;j++){
                for(int l=1;l<=k;l++){
                    if(j-l>=0){
                        tab[i][j] =(tab[i][j]+tab[i-1][j-l])%mod;
                    }
                }
            }
        }
        return tab[n][target];
    }
}