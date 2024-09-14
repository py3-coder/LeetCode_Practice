class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0, longest = 0, cur = 0;
        for (int num : nums) {
            if (num == max) {
                longest = Math.max(longest, ++cur);
            }else if (num > max) {
                max = num;
                cur = longest = 1;
            }else {
                cur = 0;
            }
        }
        return longest;
    }
}