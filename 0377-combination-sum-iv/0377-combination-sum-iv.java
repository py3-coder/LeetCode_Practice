class Solution {
    static int[] memo =new int[1001];
    public int combinationSum4(int[] nums, int target) {
        //1. Recursion::
        // TLE
        //return solveRec(nums,target);

        //2.Memoization::
        //
        Arrays.fill(memo,-1);
        return solveMemo(nums,target);
    }
    public static int solveRec(int nums[],int target){
        if(target==0) return 1;
        int count=0;
        for(int i=nums.length-1;i>=0;i--){
            if(target-nums[i]<0){
                continue;
            }
            count+=solveRec(nums,target-nums[i]);
        }
        return count;
    }
    public static int solveMemo(int nums[],int target){
        if(target==0) return 1;

        if(memo[target]!=-1){
            return memo[target];
        }
        int count=0;
        for(int i=nums.length-1;i>=0;i--){
            if(target-nums[i]<0){
                continue;
            }
            count+=solveMemo(nums,target-nums[i]);
        }
        return memo[target]=count;
    }

}