class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start=0;
        int end=0;
        int sum=0,res=Integer.MAX_VALUE;
        while(end<nums.length){
            sum+=nums[end];
            while(sum>=target && start<=end){
                res=Math.min(res,end-start+1);
                sum-=nums[start++];
            }
            end++;
        }
        return res==Integer.MAX_VALUE?0:res;
    }
}