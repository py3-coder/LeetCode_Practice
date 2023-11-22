class Solution {
    static int memo[];
    public int jump(int[] nums) {
        //return solveRec(nums,0);
        memo = new int[nums.length];
        Arrays.fill(memo,-1);
        return solveMemo(nums,0);
    }
    //Recursion :::
    public static int solveRec(int[] nums,int indx){
        if(indx==nums.length-1) return 0;
        
        int cnt=9999;
        for(int i=indx+1;i<=nums[indx]+indx && i<nums.length;i++){
            cnt =Math.min(1+solveRec(nums,i),cnt);
        }
        return cnt;
    }
    public static int solveMemo(int[] nums,int indx){
        if(indx==nums.length-1) return 0;
        
        if(memo[indx]!=-1){
            return memo[indx];
        }
        int cnt=9999;
        for(int i=indx+1;i<=nums[indx]+indx && i<nums.length;i++){
            cnt =Math.min(1+solveMemo(nums,i),cnt);
        }
        return memo[indx]=cnt;
    }
    
}
