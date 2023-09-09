class Solution {
    public static int solve(int[] nums,int target,int dp[]){
        if(dp[target] !=-1){
            return dp[target];
        }
        int res=0;
        for(int i=0;i<nums.length;i++){
            if(target>=nums[i]){
                 res += solve(nums,target-nums[i],dp);
            }
        }
        dp[target] =res;
        return dp[target];
    }
    public int combinationSum4(int[] nums, int target) {
        int dp[] = new int[target+1];
        Arrays.fill(dp,-1);
        dp[0] =1;
        int res = solve(nums,target,dp);
        return res;

    }
}