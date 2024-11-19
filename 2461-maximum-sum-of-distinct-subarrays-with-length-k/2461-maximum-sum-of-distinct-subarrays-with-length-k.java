class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        //Sliding window ::
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        int start =0;
        int end =0;
        long sum=0, ans =0;
        while(end<n){    
            while (set.contains(nums[end]) || set.size() == k) {
                set.remove(nums[start]);
                sum -= nums[start++];
            }
            sum += nums[end];
            set.add(nums[end]);
            if (set.size() == k) {
                ans = Math.max(ans, sum);
            }
            end++;
        }
        return ans;
    }
}