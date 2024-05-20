class Solution {
    public int subsetXORSum(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        //return solve(nums);  
        return solveRec(nums,0,0);
    }
    
    public int solve(int[] nums){
        int n= nums.length;
        int sum=0;
        for(int i=0;i<(1<<n);i++){
            int xor=0;
            for(int j=0;j<n;j++){
                if((i & (1<<j))!=0){
                    xor^=nums[j];
                }
            }
            sum+=xor;
        }
        return sum;
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