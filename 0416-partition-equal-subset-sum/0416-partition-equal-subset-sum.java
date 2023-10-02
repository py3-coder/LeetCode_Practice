class Solution {
    static int[][] memo = new int[101][100001];
	public static boolean canPartition(int[] arr) {
		// Write your code here.
		int sum =0;
        for(int ele:arr){
            sum+=ele;
        }
        if(sum%2==1) return false;
        else{
            sum =sum/2;
            int n=arr.length;
            return solveTab(n,arr,sum)==0?false:true;
        }
	}
	public static int solveRec(int n,int arr[] ,int target){
        if(target==0) return 1;
        if(n==0) return 0;

        if(arr[n-1]>target){
            return solveRec(n-1,arr,target);
        }else{
            return Math.max(solveRec(n-1,arr,target-arr[n-1]),solveRec(n-1,arr,target));
        }
    }
	public static int solvememo(int n,int arr[],int target){
        //Base ::
        if(target==0) return 1;
        if(n==0) return 0;
        
        //check pre-camputed ?
        if(memo[n][target]!=-1){
            return memo[n][target];
        }
        if(arr[n-1]>target){
            //not possible to pick --> Not pick Case ::
            return memo[n][target]=solvememo(n-1,arr,target);
        }else{
            //pick and not pick case::
        return memo[n][target]=Math.max(solvememo(n-1,arr,target-arr[n-1]),solvememo(n-1,arr,target));
        }
    }
    public static int solveTab(int n,int  arr[] ,int target){
        //Base --> initlization
        int tab[][] = new int[n+1][target+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<target+1;j++){
                if(i==0){
                    tab[i][j]=0;
                }
                if(j==0){
                    tab[i][j]=1;
                }
            }
        }
        
        for(int i=1;i<n+1;i++){
            for(int j=1;j<target+1;j++){
                if(arr[i-1]>j){
                    tab[i][j]=tab[i-1][j];
                }else{
                    tab[i][j] =Math.max(tab[i-1][j-arr[i-1]],tab[i-1][j]);
                }
            }
        }
        return tab[n][target];
    }
}