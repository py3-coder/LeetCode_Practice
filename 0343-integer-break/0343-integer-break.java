class Solution {
    static int memo[][] =new int[59][59];
    public int integerBreak(int n) {
        if(n==2) return 1;
        if(n==3) return 2;
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=i+1;
        }
        // return solveRec(n,arr,n);
        //2. Memoization::
        Arrays.stream(memo).forEach(a->Arrays.fill(a,-1));
        return solveMemo(n,arr,n);

    }
    public static int solveRec(int n,int[] arr,int target){
        if(n==0 || target==0 ) return 1;
        if(arr[n-1]>target){
            return solveRec(n-1,arr,target);
        }else{
        return Math.max(arr[n-1]*solveRec(n,arr,target-arr[n-1]),solveRec(n-1,arr,target));
        }
    }
    public static int solveMemo(int n,int[] arr,int target){
        if(n==0 || target==0 ) return 1;
        if(memo[n][target]!=-1){
            return memo[n][target];
        }
        if(arr[n-1]>target){
            return memo[n][target]=solveRec(n-1,arr,target);
        }else{
        return memo[n][target]=Math.max(arr[n-1]*solveRec(n,arr,target-arr[n-1]),solveRec(n-1,arr,target));
        }
    }
    
}