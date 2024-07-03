class Solution {
    public int minDifference(int[] nums) {
        int n = nums.length;
        if(n<=4) return 0;
        Arrays.sort(nums);
        int res =Integer.MAX_VALUE;
        int left = 0 , right = n-4;
        while(right<n){
            res  = Math.min(res,nums[right]-nums[left]);
            right++;
            left++;
        }
        return res;
    }
}