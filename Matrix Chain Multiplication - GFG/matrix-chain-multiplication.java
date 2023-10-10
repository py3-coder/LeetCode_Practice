//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.matrixMultiplication(N, arr));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int memo[][] = new int[501][501];
    static int matrixMultiplication(int N, int arr[])
    {
        // Lets Play with DP:)
        //return solveRec(arr,1,N-1);
        Arrays.stream(memo).forEach(a->Arrays.fill(a,-1));
        return solveMemo(arr,1,N-1);
    }
    public static int solveRec(int arr[],int i,int j){
        //Base Case::
        if(i>=j){
            return 0;
        }
        int ans=Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            int temp=solveRec(arr,i,k)+solveRec(arr,k+1,j)+(arr[i-1]*arr[k]*arr[j]);
            if(temp<ans){
                ans=temp;
            }
        }
        return ans;
    }
    public static int solveMemo(int arr[],int i,int j){
        //Base Case::
        if(i>=j){
            return 0;
        }
        if(memo[i][j]!=-1){
            return memo[i][j];
        }
        int ans=Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            int temp=solveMemo(arr,i,k)+solveMemo(arr,k+1,j)+(arr[i-1]*arr[k]*arr[j]);
            if(temp<ans){
                ans=temp;
            }
        }
        return memo[i][j]=ans;
    }
}