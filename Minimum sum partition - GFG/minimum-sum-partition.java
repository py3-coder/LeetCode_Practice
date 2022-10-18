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
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{

	public int minDifference(int arr[], int n) 
	{ 
	    // Your code goes here
	    int sum=0;
	    for(int i=0;i<n;i++){
	        sum +=arr[i];
	    }
	    n=arr.length;
	    List<Integer> res = new ArrayList<>();
	    subsetsum_tab(arr,sum/2+1,n,res);
	    
	    int mini =Integer.MAX_VALUE;
	    for(int ele :res){
	        mini =Math.min(mini,sum-(2*ele));
	    }
	    return mini;
	    
	} 
	public static void subsetsum_tab(int[] arr,int sum,int n,List<Integer> res){
        boolean dp[][] = new boolean[arr.length+1][sum+1];
        for(int i=0;i<n+1;i++){
            dp[i][0] =true;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                if(arr[i-1]>j){
                    dp[i][j]= dp[i-1][j];
                }else{
                    dp[i][j]= dp[i-1][j] || dp[i-1][j-arr[i-1]];
                }
            }
        }
        for(int i=0;i<sum;i++){
            if(dp[n][i]==true){
                res.add(i);
            }
        }
    }
}
