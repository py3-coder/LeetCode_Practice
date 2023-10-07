class Solution {
    public int numSquares(int n) {
        // int arr[] = new int[n];
        // for(int i=0;i<n;i++){
        //     arr[i] =(i+1)*(i+1);
        // }
        //return solveRec(n,arr,n);
        // int[][] memo=new int[n+1][n+1];
        // Arrays.stream(memo).forEach(a->Arrays.fill(a,-1));
        // return solveMemo(n,arr,n,memo);
        
        // MLE - Memory Limit Error::

        //return solveTab(n,arr);
        // // MLE - Memory Limit Error::

        int memo[] = new int[n+1];
        Arrays.fill(memo,-1);
        return solveMemoDiff(n,memo);

    } 
    public static int solveRec(int n,int arr[],int target){
        if(target==0) return 0;
        if(target==1) return 1;
        if(n==0) return Integer.MAX_VALUE-1;

        if(arr[n-1]>target){
            return solveRec(n-1,arr,target);
        }
        else{
            return Math.min(1+solveRec(n,arr,target-arr[n-1]),solveRec(n-1,arr,target));
        }
    }
    public static int solveMemo(int n,int arr[],int target,int[][] memo){
        if(target==0) return 0;
        if(target==1) return 1;
        if(n==0) return Integer.MAX_VALUE-1;
        if(memo[n][target]!=-1){
            return memo[n][target];
        }
        if(arr[n-1]>target){
            return memo[n][target]=solveMemo(n-1,arr,target,memo);
        }
        else{
            return memo[n][target]=Math.min(1+solveMemo(n,arr,target-arr[n-1],memo),solveMemo(n-1,arr,target,memo));
        }
    }
    public static int solveTab(int n,int arr[]){
        //tabulation::
        int tab[][]  = new int[n+1][n+1];
        for(int i=0;i<n+1;i++){
            tab[0][i] =Integer.MAX_VALUE-1;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                if(arr[i-1]>j){
                    tab[i][j] = tab[i-1][j];
                }else{
                    tab[i][j] =Math.min(1+tab[i][j-arr[i-1]],tab[i-1][j]);
                }
            }
        }
        return tab[n][n];
    }
    public static int solveMemoDiff(int n ,int memo[]){
        if(n==0) return 0;
        if(memo[n]!=-1){
            return memo[n];
        }

        int ans=n;
        for(int i=1;i*i<=n;i++){
            int temp =i*i;
            ans =Math.min(ans,1+solveMemoDiff(n-temp,memo));
        }
        memo[n]=ans;
        return memo[n];
    }
}