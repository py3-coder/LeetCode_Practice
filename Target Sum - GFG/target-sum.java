//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            int[] A = new int[N];
            
            for(int i=0 ; i<N ; i++){
                A[i] = Integer.parseInt(S[i]);
            }
            int target = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.findTargetSumWays(A,N, target));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int[][] memo =new int[101][1001];
    static int findTargetSumWays(int[] arr , int n, int target) {
        // code here
        //Lets Play with Recursion::
        //1. Recursion:
        // TC : O(2^n)
        //SC :O(1)
        return solveRec(arr,n,target);
        //2. Memo:
        // Arrays.stream(memo).forEach(a->Arrays.fill(a,-1));
        // return solveMemo(arr,n,target);
        
    }
    public static int solveRec(int[] arr,int n,int target){
        if(n==0){
            if(target==0){
                return 1;
            }
            return 0;
        }
        //add or substract::
        return solveRec(arr,n-1,target-arr[n-1])+solveRec(arr,n-1,target+arr[n-1]);
    }
    public static int solveMemo(int[] arr,int n,int target){
       if(n==0){
            if(target==0){
                return 1;
            }
            return 0;
        } 
        if(memo[n][target]!=-1){
            return memo[n][target];
        }
        return memo[n][target] =solveMemo(arr,n-1,target-arr[n-1])+solveMemo(arr,n-1,target+arr[n-1]);
    }
}