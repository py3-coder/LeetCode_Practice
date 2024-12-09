class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long[] ps = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            ps[i + 1] = ps[i] + nums[i];
        }
        long res=Long.MIN_VALUE;;
        for (int p = 0; p < k; p++) {
            long sum = 0;
            for (int i = p; i + k <= nums.length; i += k) {
                long curr = ps[i + k] - ps[i]; 
                sum = Math.max(curr, sum + curr); 
                res = Math.max(res, sum);  
            }
        }
        return res;
    }
}