class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        //write your code here
        // TC : O(2^n)  SC: O(1) :: TLE
        Arrays.sort(rides,(a,b)->a[0]-b[0]);
        // return solveRec(0,-1,rides,n);

        //TC : O(n^2)  SC: O(n^2) :: TLE
        // long memo[][] = new long[rides.length+1][rides.length+10];
        // Arrays.stream(memo).forEach(a->Arrays.fill(a,-1));
        // return solveMemo(0,-1,rides,n,memo);

        //TC :: O(n) SC: O(1)
        long dp[] = new long[rides.length];
        Arrays.fill(dp,-1);
        return solver(rides,n,0,dp);
        
    }
    public static long solveRec(int indx,int prev,int[][] rides,int n){
        //Base Case ::
        if(indx>=rides.length) return 0;
        long pick=0;
        if((prev==-1 || rides[prev][1]<=rides[indx][0]) && rides[indx][0]<n){
            pick =rides[indx][1]+rides[indx][2]-rides[indx][0]+solveRec(indx+1,indx,rides,n);
        }
        long notpick=solveRec(indx+1,prev,rides,n);
        return Math.max(pick,notpick);
    }

    public static long solveMemo(int indx,int prev,int[][] rides,int n,long[][] memo){
        if(indx>=rides.length) return 0;
        
        //check pre camputed::
        // did co-ordinate shift due to -1:
        if(memo[indx][prev+1]!=-1){
            return memo[indx][prev+1];
        }
        long pick=0;
        if((prev==-1 || rides[prev][1]<=rides[indx][0]) && rides[indx][0]<n){
            pick =rides[indx][1]+rides[indx][2]-rides[indx][0]+solveMemo(indx+1,indx,rides,n,memo);
        }
        long notpick=solveMemo(indx+1,prev,rides,n,memo);
        return Math.max(pick,notpick);
    }
    public static long solver(int[][] rides,int n,int indx,long[] dp){
        if(indx==rides.length) return 0;
        if(dp[indx]!=-1) return dp[indx];
    
        long notpick =solver(rides,n,indx+1,dp);
        long pick = rides[indx][1]-rides[indx][0]+rides[indx][2]
        +solver(rides, n, binarySearch(rides, rides.length, indx, rides[indx][1]), dp);

        return dp[indx] = Math.max(notpick, pick);
    }
    public static int binarySearch(int[][] arr,int n,int lo,int target){
        int hi=n-1;
        int ans=n;
        while(lo<=hi){
            int mi =lo+(hi-lo)/2;
            if(arr[mi][0]>=target){
                ans=mi;
                hi=mi-1;
            }else{
                lo =mi+1;
            }
        }
        return ans;
    }
    
}