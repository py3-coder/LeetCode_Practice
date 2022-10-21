//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int v = sc.nextInt();
                    int m = sc.nextInt();
                    int coins[] = new int[m];
                    for(int i = 0;i<m;i++)
                        coins[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minCoins(coins, m, v));
                }
        }
}    
// } Driver Code Ends


class Solution{

	public int minCoins(int coins[], int M, int V) 
	{ 
	    // Recursion driver
	    //int ans =minCoin_R(coins,V);
	    //return (ans==Integer.MAX_VALUE)?-1:ans;
	    
	    //memo driver
	    //int dp[] = new int[V+1];
	    //Arrays.fill(dp,-1);
	    //int ans =min_coin_Memo(coins,V,dp);
	    //return (ans==Integer.MAX_VALUE)?-1:ans;
	    
        // Tabu driver	  
	    return  min_coin_tabu(coins,V);
	} 
	// Recursive Approch:
	public int minCoin_R(int coins[],int sum){
	    if(sum == 0 ) return 0;
	    if(sum<0) return Integer.MAX_VALUE;
	    int res = Integer.MAX_VALUE;
	    for(int i=0;i<coins.length;i++){
	        if(coins[i]<=sum){
	            int ans =minCoin_R(coins,sum-coins[i]);
	            
	            if(ans!=Integer.MAX_VALUE){
	                 res = Math.min(res,ans+1);
	            }
	        }
	    }
	    return res;
	}
	//Memoization
	public int min_coin_Memo(int coins[],int sum,int dp[]){
	    if(sum == 0) return 0;
	    if(sum<0) return Integer.MAX_VALUE;
	    int res = Integer.MAX_VALUE;
	    if(dp[sum]!=-1){
	        return dp[sum];
	    }
	    for(int i=0;i<coins.length;i++){
	        if(coins[i]<=sum){
	            int ans = min_coin_Memo(coins,sum-coins[i],dp);
	            
	            if(ans !=Integer.MAX_VALUE){
	            res = Math.min(res,ans+1);
	            }
	        }
	    }
	    return dp[sum]=res;
	}
	//Tabulation 
	public int min_coin_tabu(int coins[],int sum){
	    int dp[][] = new int[coins.length+1][sum+1];
	    dp[0][0] =0;
	    for(int i=1;i<sum+1;i++){
	        dp[0][i] = Integer.MAX_VALUE-1;
	    }
	    for(int i=1;i<coins.length+1;i++){
	        dp[i][0] =0;
	    }
	    for(int i=1;i<sum+1;i++){
	        if(i%coins[0]==0){
	            dp[1][i] = i/coins[0];
	        }else{
	            dp[1][i] =Integer.MAX_VALUE-1;
	        }
	    }
	    for(int i=2;i<coins.length+1;i++){
	        for(int j=1;j<sum+1;j++){
	            if(coins[i-1]>j){
	                dp[i][j] =dp[i-1][j];
	            }else{
	                dp[i][j] =Math.min(dp[i-1][j] ,1+dp[i][j-coins[i-1]]);
	            }
	        }
	    }
	    return (dp[coins.length][sum]==Integer.MAX_VALUE-1)?-1:dp[coins.length][sum];
	}
}