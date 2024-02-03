class Solution {
    static int memo[][] = new int[501][501];
    public int maxSumAfterPartitioning(int[] arr, int k) {
        //Lets Play with DP:)
        //1. Recursion :)
        //return solveRec(arr,k,0,arr.length-1);

        //2. Memoisation:)
        Arrays.stream(memo).forEach(a->Arrays.fill(a,-1));
        return solveMemo(arr,k,0,arr.length-1);
        // TC : O()
        
    }
    public static int solveRec(int arr[],int k,int i,int j){
        //Base Case ::
        if(i==j) return arr[i];
        if(j-i+1<=k){
            int maxi=0;
            for(int e=i;e<=j;e++){
                maxi =Math.max(arr[e],maxi);
            }
            return  maxi*(j-i+1);
        }
        //K loop:
        int ans =0;
        for(int p=i;p<i+k && p<j;p++){
            int temp = solveRec(arr,k,i,p)+solveRec(arr,k,p+1,j);
            ans =Math.max(temp,ans);
        }
        return ans;
    }
    public static int solveMemo(int arr[],int k,int i,int j){
        //Base Case ::
        if(i==j) return arr[i];
        if(memo[i][j]!=-1){
            return memo[i][j];
        }
        if(j-i+1<=k){
            int maxi=0;
            for(int e=i;e<=j;e++){
                maxi =Math.max(arr[e],maxi);
            }
            return  maxi*(j-i+1);
        }
        //K loop:
        int ans =Integer.MIN_VALUE;
        for(int p=i;p<i+k && p<j;p++){
            int leftpart,rightpart;
            if(memo[i][p]!=-1){
                leftpart=memo[i][p];
            }else{
                leftpart=solveMemo(arr,k,i,p);
            }

            if(memo[p+1][j]!=-1){
                rightpart =memo[p+1][j];
            }else{
                rightpart=solveMemo(arr,k,p+1,j);
            }
            int temp = leftpart+rightpart;
            ans =Math.max(temp,ans);
            memo[i][j]=ans;
        }
        memo[i][j]=ans;
        return ans;
    }
}