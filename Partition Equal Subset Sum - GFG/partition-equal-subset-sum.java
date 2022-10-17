//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int equalPartition(int n, int arr[])
    {
        // code here
        int sum =0;
        for(int i=0;i<n;i++){
            sum +=arr[i];
        }
        if(sum%2!=0){
            return 0;
        }else{
            sum =sum/2;
            Boolean dp[][] = new Boolean[n+1][sum+1];
            boolean res= subsetsum_Memo(arr, sum,n-1,dp);
            if(res==true) return 1;
            else return 0;
        }
    }
    public static boolean subsetsum_Memo(int[] arr,int sum,int n,Boolean dp[][]){
        if(sum==0) return true;
        if(n==0) return false;
        if(dp[n][sum]!=null){
            return dp[n][sum];
        }
        if(arr[n]>sum){
            return subsetsum_Memo(arr,sum,n-1,dp);
        }else{
            boolean pick = subsetsum_Memo(arr,sum-arr[n],n-1,dp);
            boolean not_pick =subsetsum_Memo(arr,sum,n-1,dp);
            
            dp[n][sum]=(pick||not_pick);
            return dp[n][sum];
        }
    }
}