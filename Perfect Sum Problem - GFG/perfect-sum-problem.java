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
    static int mod=1000000007;
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	    //Lets Play with Recursion::
	    //1. Recursion Call ::
	    //TC : O(2^n)
	    //SC :O(1) + Aux =O(n)
	    //return solveRec(arr,n,sum);
	    //2. Memo Call
	    int memo[][]=new int[n+1][sum+1];
	    Arrays.stream(memo).forEach(a->Arrays.fill(a,-1));
	    return solveMemo(arr,n,sum,memo);
	    
	    
	} 
	public static int solveRec(int arr[] ,int n, int sum){
	    //Base Case :: Why am I adding ?? Since When we got req sum just return 1 which iclude:
	    if(n==0){
	        if(sum==0) return 1;
	        return 0;
	    }
	    if(arr[n-1]>sum){
	        return solveRec(arr,n-1,sum);
	    }else{
	        return solveRec(arr,n-1,sum-arr[n-1])+solveRec(arr,n-1,sum)%mod;
	    }
	}
	public static int solveMemo(int arr[] ,int n, int sum,int[][] memo){
	    //Base Case :: Why am I adding ?? Since When we got req sum just return 1 which iclude:
	    if(n==0){
	        if(sum==0) return 1;
	        return 0;
	    }
	    if(memo[n][sum]!=-1){
	        return memo[n][sum];
	    }
	    if(arr[n-1]>sum){
	        return memo[n][sum]=solveMemo(arr,n-1,sum,memo);
	    }else{
	        memo[n][sum]=(solveMemo(arr,n-1,sum-arr[n-1],memo)%mod)+(solveMemo(arr,n-1,sum,memo)%mod);
	        return memo[n][sum]=memo[n][sum]%mod;
	    }
	}
}