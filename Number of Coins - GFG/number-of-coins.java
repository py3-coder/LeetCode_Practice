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
	    //return (minCoin_R(coins,V)==Integer.MAX_VALUE)?-1:min_coin_Memo(coins,V);
	    
	    //memo driver
	    int dp[] = new int[V+1];
	    Arrays.fill(dp,-1);
	    int ans =min_coin_Memo(coins,V,dp);
	    return (ans==Integer.MAX_VALUE)?-1:ans;
	    
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
	
}