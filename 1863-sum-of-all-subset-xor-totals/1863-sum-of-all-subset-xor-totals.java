class Solution {
    public int subsetXORSum(int[] nums) {
        //Recursion :: O(2^n)
        return solveRec(nums,0,0);
    }
    public static int solveRec(int[] nums,int indx,int xor){
        if(indx==nums.length){
            return xor;
        }
        
        int pick = solveRec(nums,indx+1,xor^nums[indx]);
        int notpick =solveRec(nums,indx+1,xor);
        
        return pick+notpick;
    }
}