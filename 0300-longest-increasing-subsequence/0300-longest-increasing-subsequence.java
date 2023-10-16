class Solution {
    static int memo[][] = new int[2501][2501];
    public int lengthOfLIS(int[] nums) {
        //Recursion:: TC: O(2^n) SC - O(1)+O(n) --Aux space::
        //return solveRec(0,-1,nums);

        Arrays.stream(memo).forEach(a->Arrays.fill(a,-1));
        return solveMemo(0,-1,nums);

    }
    public static int solveRec(int indx,int prev,int nums[]){
        //Base Case ::
        if(indx>=nums.length) return 0;
        //choice we have : either part of LIS or not be the part of LIS:
        // Take not take case:: comes in picture::
        int pick=0;
        if(prev==-1 || nums[prev]<nums[indx]){
            pick = 1+solveRec(indx+1,indx,nums);
        }
        int notpick =solveRec(indx+1,prev,nums);
        return Math.max(pick,notpick);
    }
    public static int solveMemo(int indx,int prev,int nums[]){
        //Base Case ::
        if(indx>=nums.length) return 0;
        //choice we have : either part of LIS or not be the part of LIS:
        // Take not take case:: comes in picture::
        // why I am using prev+1 == because -1 indx not possible so increase every index by 1::
        if(memo[indx][prev+1]!=-1){
            return memo[indx][prev+1];
        }
        int pick=0;
        if(prev==-1 || nums[prev]<nums[indx]){
            pick = 1+solveMemo(indx+1,indx,nums);
        }
        int notpick =solveMemo(indx+1,prev,nums);
        return memo[indx][prev+1]=Math.max(pick,notpick);
    }
}