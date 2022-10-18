class Solution {
    public boolean solveR(int nums[],int sum,int index,Boolean dp[][]){
        if(index>=nums.length || sum <0) return false;
        if(sum ==0) return true;
        if(dp[index][sum]!=null){
            return dp[index][sum];
        }
        return dp[index][sum] =(solveR(nums,sum-nums[index],index+1,dp) || solveR(nums,sum,index+1,dp));
        }
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
           sum+=nums[i];
        }
        if(sum%2==0){
            Boolean dp[][] = new Boolean[nums.length+1][sum+1];
            return solveR(nums,sum/2,0,dp);
        }else{
            return false;
        }
    }
}