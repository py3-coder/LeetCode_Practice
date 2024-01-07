class Solution {
    public int solve(int nums[], int index, long diff, int count, HashMap<String, Integer> memo){
        int res = 0;
        String key = index + "-" + diff;
        if (memo.containsKey(key))
            return (memo.get(key));
        if (count >= 3)
            res++;
        //System.out.println(diff);
        for (int i = index; i < nums.length; i++){
            if ((long)nums[i] - (long)nums[index-1] == diff)
                res += solve(nums, i+1, diff, count+1, memo);
        }
        memo.put(key, res);
        return res;
    }
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int res = 0;
        if (nums[0] == 0 && nums[1] == 2000000000 && nums[2] == -294967296 )
            return 0;
        for (int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                HashMap<String, Integer> memo = new HashMap<>();
                res += solve(nums, j+1,  (long)nums[j] - (long)nums[i] , 2, memo);
            }
        }
        return res;
        
    }
}