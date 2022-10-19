//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sum = sc.nextInt();
            int N = sc.nextInt();
            int coins[] = new int[N];
            for (int i = 0; i < N; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}


// } Driver Code Ends


// User function Template for Java

class Solution {
    public long count(int coins[], int N, int sum) {
        // code here.
        // Recursion Driver Code :
        //return count_R(coins,N-1,sum);
        
        // Memoization Driver Code :
        //long dp[][] = new long[N+1][sum+1];
        //Arrays.stream(dp).forEach(a->Arrays.fill(a,-1));
        //return count_Memo(coins,N-1,sum,dp);
        
        return count_Tab(coins,sum);
    }
    // Similar to Unbounded knapsack think of --> Count of Subset sum problem just do some modification
    // you will enjoy it..
    
    // Recursion 
    public long count_R(int coins[],int n,int sum){
        if(sum ==0) return 1;
        if(n<0) return 0;
        
        if(coins[n]>sum){
            return count_R(coins,n-1,sum);
        }else{
            return count_R(coins,n-1,sum) + count_R(coins,n,sum-coins[n]);
        }
    }
    
    // Memoization 
    public long count_Memo(int coins[],int n,int sum,long dp[][]){
        if(sum ==0) return 1;
        if(n<0) return 0;
        if(dp[n][sum]!=-1) return dp[n][sum];
        if(coins[n]>sum){
            return dp[n][sum]= count_Memo(coins,n-1,sum,dp);
        }else{
            return dp[n][sum]= count_Memo(coins,n-1,sum,dp) + count_Memo(coins,n,sum-coins[n],dp);
        }
    }
    // Tabulation
    public long count_Tab(int coins[],int sum){
        int n=coins.length;
        long dp[][] = new long[n+1][sum+1];
        for(int i=0;i<n+1;i++){
            dp[i][0] =1;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
             if(coins[i-1]>j){
                dp[i][j] = dp[i-1][j];
            }else{
                dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[n][sum];
    }
}