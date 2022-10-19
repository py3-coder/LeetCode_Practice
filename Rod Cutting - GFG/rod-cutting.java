//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int n) {
        //code here
        int len[] = new int[n];
        for(int i=0;i<n;i++)
        len[i] =i+1;
        //Recursion
        //return cutRod_R(price,len,n,n);
        //memo
        //int dp[][] = new int[n+1][n+1];
        //Arrays.stream(dp).forEach(a->Arrays.fill(a,-1));
        //return cutRod_M(price,len,n,n,dp);
        //Tabu
        return cutRod_Tabulation(price,len,n);
        
    }
    //Recursion 
    public static int cutRod_R(int price[],int len[],int n,int L){
    if(L==0 || n==0) return 0;
    if(len[n-1]>L){
        return cutRod_R(price,len,n-1,L);
    }else{
        return Math.max(cutRod_R(price,len,n-1,L),price[n-1]+cutRod_R(price,len,n,L-len[n-1]));
        }
    }
    // Memoization
    public static int cutRod_M(int price[],int len[],int n,int L,int dp[][]){
    if(L==0 || n==0) return 0;
    if(dp[n][L]!=-1) return dp[n][L];
    if(len[n-1]>L){
        return dp[n][L]=cutRod_M(price,len,n-1,L,dp);
    }else{
        return dp[n][L]=Math.max(cutRod_M(price,len,n-1,L,dp),price[n-1]+cutRod_M(price,len,n,L-len[n-1],dp));
        }
    }
    //Tabulation
    public static int cutRod_Tabulation(int price[],int len[],int n){
        
        int dp[][] = new int[n+1][n+1];
        
        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                if(len[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],price[i-1]+dp[i][j-len[i-1]]);
                }
            }
        }
        return dp[n][n];
    }
}