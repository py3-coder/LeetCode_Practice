class Solution {
    static int[] memo = new int[101];
    public int rob(int[] nums) {
        int n=nums.length;
        //Recursion::
        //return solveRec(nums,n-1);
        Arrays.fill(memo,-1);
        return solveMemo(nums,n-1);
        
    }
    public static int solveRec(int[] arr,int n){
        //Base Case ::
        if(n<0) return 0;
        //Choices we have ::
        int rob = arr[n] +solveRec(arr,n-2);
        int notrob =solveRec(arr,n-1);

        return memo[n]=Math.max(rob,notrob);
    }
    public static int solveMemo(int[] arr,int n){
        //Base Case ::
        if(n<0) return 0;
        // precamputed value::
        if(memo[n]!=-1){
            return  memo[n];
        }
        //Choices we have ::
        int rob = arr[n] +solveMemo(arr,n-2);
        int notrob =solveMemo(arr,n-1);

        return memo[n]=Math.max(rob,notrob);
    }
   
}