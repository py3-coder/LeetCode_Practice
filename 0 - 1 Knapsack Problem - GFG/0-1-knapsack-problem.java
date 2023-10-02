//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}




// } Driver Code Ends


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int[][] memo = new int[1001][1001];
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         //Lets Play with Recursion ::
         //1. Call Recursion::
         //return solveRec(W,wt,val,n);
         // TLE :: 1156/1210
         //2. Memo::
         //best ways to fill 2d array with single value::
         Arrays.stream(memo).forEach(a -> Arrays.fill(a, -1));
         return solveMemo(W,wt,val,n);
         
    } 
    public static int solveRec(int w ,int wt[] ,int val[],int n){
        //Base Case ::
        if(w==0 || n==0){
            return 0;
        }
        //
        if(wt[n-1]>w){
            //not pick case since wt is greater::
            return solveRec(w,wt,val,n-1);
        }else{
            //pick and not pick :: max 
            return Math.max(val[n-1]+solveRec(w-wt[n-1],wt,val,n-1),solveRec(w,wt,val,n-1));
        }
    }
    public static int solveMemo(int w ,int wt[] ,int val[],int n){
        //Base Case ::
        if(w==0 || n==0){
            return 0;
        }
        //check pre-calculated ::
        if(memo[n][w]!=-1){
            return memo[n][w];
        }
        if(wt[n-1]>w){
            //not pick case since wt is greater::
            return memo[n][w]=solveMemo(w,wt,val,n-1);
        }else{
            //pick and not pick :: max 
            return memo[n][w]=Math.max(val[n-1]+solveMemo(w-wt[n-1],wt,val,n-1),solveMemo(w,wt,val,n-1));
        }
    }
    
}


