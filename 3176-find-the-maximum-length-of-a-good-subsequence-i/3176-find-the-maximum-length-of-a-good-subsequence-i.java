class Solution {
    static  int[][][]dp = new int[501][501][26];
    public int solve(int []nums, int index, int k, int pre){
        if(index == nums.length){
            return 0;
        }
        if(pre == -1){
            return Math.max(1+solve(nums, index+1, k, index), solve(nums, index+1, k, pre));
        }
        if(dp[index][pre][k] != -1){
            return dp[index][pre][k];
        }

        if(k == 0){
            if(nums[index] == nums[pre]){
                dp[index][pre][k] = 1+solve(nums, index+1, k, index);
            }
            else{
                dp[index][pre][k] = solve(nums, index+1, k, pre);
            }
        }
        else{
            if(nums[index] == nums[pre]){
                dp[index][pre][k] = Math.max(1+solve(nums, index+1, k, index), solve(nums, index+1, k, pre));
            }
            else{
                dp[index][pre][k] = Math.max(1+solve(nums, index+1, k-1, index), solve(nums, index+1,k, pre));
            }
        }
        return dp[index][pre][k];
    }
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        for(int [][]a : dp){
            for(int []b : a){
                Arrays.fill(b, -1);
            }
        }
        
        return solve(nums, 0, k, -1);
    }
}
