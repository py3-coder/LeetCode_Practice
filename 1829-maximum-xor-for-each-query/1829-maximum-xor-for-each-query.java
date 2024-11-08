class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
         int xor = 0, n = nums.length;
        int max = (1 << maximumBit) - 1;
        int res[] = new int[n];
        
        for(int e : nums) xor ^= e;//xor all elements
        
        for(int i = 0; i < n; i++){
            res[i] = xor ^ max;// k = xor ^ max
            xor ^= nums[n - i - 1];//remove last element from xor
        }
        return res;
    }
}