class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int maxOr = 0;
        
        for(int e : nums) maxOr |= e;
        
        return dfs(nums, 0, 0, maxOr);
    }
    
    private int dfs(int[] nums, int i, int currOr, int maxOr) {
        if(i == nums.length) return currOr == maxOr ? 1 : 0;
        
        return dfs(nums, i + 1, currOr | nums[i], maxOr) + dfs(nums, i + 1, currOr, maxOr);
    }
}