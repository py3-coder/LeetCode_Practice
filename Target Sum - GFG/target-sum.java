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
        // TestCase Passed All:)
        //return solveRec(arr,n,target);
        //2. Memo :) Since target range => -1000<=Traget <= 1000::
        // Can stote in 2d matrix : Think of other data structure -> HashMap ?
        ArrayList<Map<Integer,Integer>> memo = new ArrayList<>(n+1);
        for(int i=0;i<n+1;i++){
            memo.add(new HashMap<Integer,Integer>());
        }
        return solveMemo(arr, n, target,memo);
        
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
    public static int solveMemo(int[] arr, int n,int target,ArrayList<Map<Integer,Integer>> memo){
        if(n==0){
            if(target==0){
                return 1;
            }
            return 0;
        }
        if(memo.get(n).containsKey(target)){
            return memo.get(n).get(target);
        }
        int ans=solveMemo(arr,n-1,target-arr[n-1],memo)+solveMemo(arr,n-1,target+arr[n-1],memo);
        //update the nth - map:
        memo.get(n).put(target,ans);
        return ans;
    }
}