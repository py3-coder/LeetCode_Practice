class Solution {
    public int coinChange(int[] coins, int amount) {
        // Your code goes here
	    //1. Recursion::
	    // TC : O(n^amount)
	    //SC : O(1) --> Aux O(n):
	    //return solveRec(coins.length,coins,amount);
	    
	    //2. Memo
	    //TC : O(n*v)
	   //int n=coins.length;
	   // int memo[][] = new int[n+1][V+1];
	   // Arrays.stream(memo).forEach(a->Arrays.fill(a,-1));
        //int ans=solveMemo(coins.length,coins,amount);
	   // return ans==Integer.MAX_VALUE-1?-1:ans;
	   
	   //3.Tabulation::
	   return solveTab(coins.length,coins,amount);
    }
    public static int solveRec(int n,int coins[],int sum){
	    //Base ::
	    if(sum==0) return 0;
	    if(n==0) return Integer.MAX_VALUE-1;
	    if(coins[n-1]>sum){
	        return solveRec(n-1,coins,sum);
	    }else{
	        return Math.min(1+solveRec(n,coins,sum-coins[n-1]),solveRec(n-1,coins,sum));
	    }
	}
	public static int solveMemo(int n,int coins[],int sum,int [][]memo){
	    if(sum==0) return 0;
	    if(n==0) return Integer.MAX_VALUE-1;
	    
	    if(memo[n][sum]!=-1){
	        return memo[n][sum];
	    }
	    if(coins[n-1]>sum){
	        return memo[n][sum] =solveMemo(n-1,coins,sum,memo);
	    }else{
	        return memo[n][sum] =Math.min(1+solveMemo(n,coins,sum-coins[n-1],memo),solveMemo(n-1,coins,sum,memo));
	    }
	}
	public static int solveTab(int n,int coins[],int sum){
	    //Tabulation:)
	    
	    int tab[][] = new int[n+1][sum+1];
	    //base->Initlization::
	    for(int i=0;i<n+1;i++){
	        for(int j=0;j<sum+1;j++){
	            if(i==0) tab[i][j] =Integer.MAX_VALUE-1;
	            if(j==0) tab[i][j] =0;
	        }
	    }
	    for(int i=1;i<n+1;i++){
	        for(int j=1;j<sum+1;j++){
	            if(coins[i-1]>j){
	                tab[i][j] =tab[i-1][j];
	            }else{
	                tab[i][j] =Math.min(1+tab[i][j-coins[i-1]],tab[i-1][j]);
	            }
	        }
	    }
	    return tab[n][sum]==Integer.MAX_VALUE-1?-1:tab[n][sum];
	}
}