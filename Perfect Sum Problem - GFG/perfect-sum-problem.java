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
                    int n = sc.nextInt();
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends



class Solution{

    int mod=1000000007;
    int dp[][];
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	    dp=new int[n+1][sum+1];
	    for(int i=0;i<n+1;i++){
	        Arrays.fill(dp[i],-1);
	    }
	    return fun(arr,0,sum);
	}
	public int fun(int arr[],int i,int sum)
	{
	    if(sum==0){
	        int j=i;
	        int p=1;
	        while(j<arr.length && arr[j]==0){
	            p++;
	            j++;
	        }
	        return dp[i][sum]=p;
	    }
	    if(i==arr.length){
	        return dp[i][sum]=0;
	    }
	    if(dp[i][sum]!=-1)return dp[i][sum];
	    if(arr[i]<=sum)
	    return dp[i][sum]=(fun(arr,i+1,sum)+fun(arr,i+1,sum-arr[i]))%mod;
	    else
	    return dp[i][sum]=fun(arr,i+1,sum);
	}
}