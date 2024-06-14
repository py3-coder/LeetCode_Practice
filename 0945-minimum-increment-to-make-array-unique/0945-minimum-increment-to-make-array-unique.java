class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int res = 0, need = 0;
        for (int a : nums) {
            res += Math.max(need - a, 0);
            need = Math.max(a, need) + 1;
        }
        return res;
    }
}