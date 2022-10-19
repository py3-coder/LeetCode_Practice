//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int knapSack(int N, int W, int val[], int wt[])
    {
        //  Recursion Driver
        //return KnapSack_unb(N-1,W,val,wt);
        
        // Memoization Driver
        //int dp[][] = new int[N+1][W+1];
        //Arrays.stream(dp).forEach(a->Arrays.fill(a,-1));
        //return KnapScak_unb_Memo(N-1,W,val,wt,dp);
        
        //Tabulation Driver
        return KnapSack_unb_tab(N,W,val,wt);
    }
    //Recursion
    public static int KnapSack_unb_R(int n,int W,int val[],int wt[]){
        if(n==0 || W==0) return 0;
        
        if(wt[n]>W){
            return KnapSack_unb_R(n-1,W,val,wt);
        }else{
            return Math.max(KnapSack_unb_R(n-1,W,val,wt),val[n]+KnapSack_unb_R(n,W-wt[n],val,wt));
        }
    }
    //Memoization
    public static int KnapScak_unb_Memo(int n,int W,int val[],int wt[],int dp[][]){
        if(n==0 || W==0) return 0;
        if(dp[n][W]!=-1) return dp[n][W];
        
        if(wt[n]>W){
            return dp[n][W] = KnapScak_unb_Memo(n-1,W,val,wt,dp);
        }else{
            return dp[n][W] =Math.max(KnapScak_unb_Memo(n-1,W,val,wt,dp),val[n]+KnapScak_unb_Memo(n,W-wt[n],val,wt,dp));
        }
    }
    /// Tabulation
    public  static int KnapSack_unb_tab(int n,int W,int val[],int wt[]){
        
        int dp[][] = new int[n+1][W+1];
        // No need of initialization
        //Since we need initlize with 0 See the base of Recursion that is going to the initlization step 
        // so when we crate array with int by default it get 0..
        for(int i=1;i<n+1;i++){
            for(int j=1;j<W+1;j++){
                if(wt[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], val[i-1]+dp[i][j-wt[i-1]]);
                }
            }
        }
        return dp[n][W];
    }
}