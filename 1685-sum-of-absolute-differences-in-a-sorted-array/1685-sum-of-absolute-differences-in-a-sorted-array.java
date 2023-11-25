class Solution {
     public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        for (int i = 0; i < n; ++i) {
            res[i] = i * nums[i] - prefixSum[i] + (prefixSum[n] -  prefixSum[i] - (n - i) * nums[i]);
        }
        return res;
    }
}