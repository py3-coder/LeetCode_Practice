class Solution {
    static long[] memo = new long[100001];
    public long minIncrementOperations(int[] nums, int k) {
        //Recursion:) TC: O(n^3)
        //return solveRec(0,nums,k,nums.length);

        //Memoisation:)
        Arrays.fill(memo,-1);
        return solveMemo(0,nums,k,nums.length);
        
    }
    public static long solveRec(int indx,int[] nums,int k,int n){
        //Base Case ::
        if(indx>n-3) return 0;

        long take=Long.MAX_VALUE-1;
        for(int i=indx;i<n && i<indx+3;i++){
            long diff = k-nums[i]>0?k-nums[i]:0;
            long temp = diff+solveRec(i+1,nums,k,n);
            take = Math.min(take,temp);
        }
        return take;
    }
    public static long solveMemo(int indx,int[] nums,int k,int n){
        //Base Case ::
        if(indx>n-3) return 0;
        if(memo[indx]!=-1){
            return memo[indx];
        }
        long take=Long.MAX_VALUE-1;
        for(int i=indx;i<n && i<indx+3;i++){
            long diff = k-nums[i]>0?k-nums[i]:0;
            long temp = diff+solveMemo(i+1,nums,k,n);
            take = Math.min(take,temp);
        }
        return memo[indx]=take;
    }
}