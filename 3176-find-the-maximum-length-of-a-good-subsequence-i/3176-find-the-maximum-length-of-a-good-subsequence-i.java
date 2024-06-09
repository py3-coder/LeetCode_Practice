class Solution {
    public int solve(int []nums, int index, int k, int pre, int [][][]dp){
        if(index == nums.length){
            return 0;
        }
        if(pre == -1){
            return Math.max(1+solve(nums, index+1, k, index, dp), solve(nums, index+1, k, pre, dp));
        }
        if(dp[index][pre][k] != -1){
            return dp[index][pre][k];
        }

        if(k == 0){
            if(nums[index] == nums[pre]){
                dp[index][pre][k] = 1+solve(nums, index+1, k, index, dp);
            }
            else{
                dp[index][pre][k] = solve(nums, index+1, k, pre, dp);
            }
        }
        else{
            if(nums[index] == nums[pre]){
                dp[index][pre][k] = Math.max(1+solve(nums, index+1, k, index, dp), solve(nums, index+1, k, pre, dp));
            }
            else{
                dp[index][pre][k] = Math.max(1+solve(nums, index+1, k-1, index, dp), solve(nums, index+1, k, pre, dp));
            }
        }
        return dp[index][pre][k];
    }
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        int[][][]dp = new int[n+1][n+1][k+1];
        for(int [][]a : dp){
            for(int []b : a){
                Arrays.fill(b, -1);
            }
        }
        
        return solve(nums, 0, k, -1, dp);
    }
}
