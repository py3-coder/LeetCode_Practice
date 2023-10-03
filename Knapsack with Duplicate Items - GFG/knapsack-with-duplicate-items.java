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
    static int[][] memo = new int[1001][1001];
    static int knapSack(int N, int W, int val[], int wt[])
    {
        // code here
        //Lets play with recursion :-
        //1.Recursion ::
        //TC : O(2^n)
        // TLE : 3/205
        // return solveRec(N,W,val,wt);
        //2. Memo Call
        // TC : O(n*w)
        // SC: O(n*w)
        // Arrays.stream(memo).forEach(a -> Arrays.fill(a,-1));
        // return solveMemo(N,W,val,wt);
        //3. tab
        return solveTab(N,W,val,wt);
        
    }
    public static int solveRec(int n,int w,int val[],int wt[]){
        //Base Case ::
        if(n==0 || w==0) return 0;
        
        if(wt[n-1]>w){
            return solveRec(n-1,w,val,wt);
        }else{
            return Math.max(val[n-1]+solveRec(n,w-wt[n-1],val,wt),solveRec(n-1,w,val,wt));
        }
    }
    public static int solveMemo(int n,int w,int val[],int wt[]){
       //Base Case ::
        if(n==0 || w==0) return 0;
        
        if(memo[n][w]!=-1){
            return memo[n][w];
        }
        if(wt[n-1]>w){
            return memo[n][w]=solveMemo(n-1,w,val,wt);
        }else{
            return memo[n][w]=Math.max(val[n-1]+solveMemo(n,w-wt[n-1],val,wt),solveMemo(n-1,w,val,wt));
        } 
    }
    public static int solveTab(int n,int w,int val[],int wt[]){
        //
        int tab[][] = new int[n+1][w+1];
        // Base Case - Initlization::
        // o is default value of array so no need to fill it manually::
        for(int i=1;i<n+1;i++){
            for(int j=1;j<w+1;j++){
                if(wt[i-1]>j){
                    tab[i][j] = tab[i-1][j];
                }else{
                    tab[i][j] = Math.max(val[i-1]+tab[i][j-wt[i-1]],tab[i-1][j]);
                }
            }
        }
        return tab[n][w];
    }
}