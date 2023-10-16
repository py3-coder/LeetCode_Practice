class Solution {
    static int memo[] = new int[101];
    public int rob(int[] nums) {
        //Recursion::
        //Doing the same just with just bit mofication::
        //Since Case of circular :: we can't take 0 and n-1 at same time:: either case::
        // better use some reduced array ::
        
        //edge case:: Have you eye open:)
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        // Arrays.fill(memo,-1);
        // int skipfirst =solveMemo(nums,nums.length-1,1);
        // Arrays.fill(memo,-1);
        // int skiplast=solveMemo(nums,nums.length-2,0);
        // return Math.max(skipfirst,skiplast);

        int firstskip=solveOptimised(nums,1,nums.length-1);
        int lastskip=solveOptimised(nums,0,nums.length-2);

        return Math.max(firstskip,lastskip);
        
    }
    public static int solveRec(int[] arr,int n,int i){
        //base case::
        if(n<i) return 0;
        //choice we have::
        int rob=arr[n]+solveRec(arr,n-2,i);
        int notrob =solveRec(arr,n-1,i);

        return Math.max(rob,notrob);
    }
     public static int solveMemo(int[] arr,int n,int i){
        //base case::
        if(n<i) return 0;
        //check pre-computed::
        if(memo[n]!=-1){
            return memo[n];
        }
        //choice we have::
        int rob=arr[n]+solveMemo(arr,n-2,i);
        int notrob =solveMemo(arr,n-1,i);

        return memo[n]=Math.max(rob,notrob);
    }
    //lets think of some optimised::
    public static int solveOptimised(int arr[],int i,int n){
        int prev2=0,prev1=0;
        for(int j=i;j<=n;j++){
            int temp =Math.max(arr[j]+prev2,prev1);
            prev2=prev1;
            prev1=temp;
        }
        return prev1;
    }
}