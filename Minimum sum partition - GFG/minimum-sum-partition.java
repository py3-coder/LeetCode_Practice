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
	    //lets Play with Recursion:)
	    // TLE: 1000/1020
	    // TC : O(2^n)
	    // SC: O(n)
	   // int total=0;
	   // for(int ele:arr){
	   //     total+=ele;
	   // }
	   // int target =(total/2)+1;
	   // ArrayList<Integer> res = new ArrayList<>();
	    //solveRec(arr,n,0,target,res);
	   // int ans =Integer.MAX_VALUE;
	   // for(int ele:res){
	   //     ans= Math.min(ans,Math.abs(total-2*ele));
	   // }
	   // return ans;
	     //Lets dive towards Memo :)
	   // int memo[][] = new int[n+1][target+1];
	   // Arrays.stream(memo).forEach(a->Arrays.fill(a,-1));
	   // int dummy =solveMemo(arr,n,0,target,res,memo);
	   // int ans =Integer.MAX_VALUE;
	   // for(int ele:res){
	   //     ans= Math.min(ans,Math.abs(total-2*ele));
	   // }
	   // return ans;
	    // key Take away :: We cant Memoize this recursion soln  beacause as per our logic there is no subproblem:
	   // ALl sum are need as per our req.
	   
	   // Lets Dive In Tab soln::
	   return solveTab(arr,n);
	   
	  
	} 
	public static void solveRec(int arr[],int n,int sum,int target,ArrayList<Integer> res){
	    // Keep the sum list till the target so that we can find min abs:
	    if(sum<=target){
	        res.add(sum);
	    }
	    //Base Case ::
	    if(n==0){
	        return ;
	    }
	    if(arr[n-1]>target){
	         solveRec(arr,n-1,sum,target,res);
	    }else{
	         solveRec(arr,n-1,sum+arr[n-1],target,res);
	         solveRec(arr,n-1,sum,target,res);
	    }
	}
// 	public static int solveMemo(int arr[],int n,int sum,int target,ArrayList<Integer> res,int[][] memo){
// 	    // Keep the sum list till the target so that we can find min abs:
// 	    if(sum<=target){
// 	        return 1;
// 	    }
// 	    //Base Case ::
// 	    if(n==0){
// 	        return 0;
// 	    }
// 	    if(memo[n][target]!=-1){
// 	        return memo[n][target];
// 	    }
// 	    if(arr[n-1]>target){
// 	         return memo[n][target]=solveMemo(arr,n-1,sum,target,res,memo);
// 	    }else{
// 	        return memo[n][target] =Math.min(solveMemo(arr,n-1,sum+arr[n-1],target,res,memo),solveMemo(arr,n-1,sum,target,res,memo));
// 	    }
// 	}
   
    public static int solveTab(int arr[],int n){
        //Subset Sum Problem Approch::
        int sum=0;
        for(int ele:arr){
            sum+=ele;
        }
        int [][]  tab = new int[n+1][sum+1];
        //Initlization::
        for(int i=0;i<n+1;i++){
            for(int j=0;j<sum+1;j++){
                if(i==0) tab[i][j]=0;
                if(j==0) tab[i][j]=1;
            }
        }
        //
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                if(arr[i-1]>j){
                    tab[i][j] = tab[i-1][j];
                }else{
                    tab[i][j] =Math.max(tab[i-1][j-arr[i-1]],tab[i-1][j]);
                }
            }
        }
        // Lets see the last row::
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<sum/2+1;i++){
            if(tab[n][i]==1){
                ans =Math.min(ans,sum-(2*i));
            }
        }
        return ans;
    }
}
