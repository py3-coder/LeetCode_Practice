class Solution {
    public int[] runningSum(int[] nums) {
        int k=0;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            nums[k++]=sum;
        }
        return nums;
    }
}