class Solution {
    public int integerBreak(int n) {
        if(n==2) return 1;
        if(n==3) return 2;
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=i+1;
        }
        return solveRec(n,arr,n,1);

        
    }
    public static int solveRec(int n,int[] arr,int target,int maxi){
        if(n==0 || target==0 ) return maxi;
        if(arr[n-1]>target){
            return solveRec(n-1,arr,target,maxi);
        }else{
        return Math.max(solveRec(n,arr,target-arr[n-1],maxi*arr[n-1]),solveRec(n-1,arr,target,maxi));
        }
    }
}