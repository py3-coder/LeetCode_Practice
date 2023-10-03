//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[])throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr, n));
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int n) {
        //code here
        // Lets Play with Recursion --> DP ::
        //1. Recursion :: 
        // TLE ::
        //TC : O(2^n)
        //SC : O(1)
        int size[] = new int[n];
        for(int i=0;i<n;i++){
            size[i] =i+1;
        }
        // return solveRec(price,size,n,n);
        //2.Memo
        // int [][] memo =new int[n+1][n+1];
        // Arrays.stream(memo).forEach(a->Arrays.fill(a,-1));
        // return solveMemo(price,size,n,n,memo);
        //3. Tab:
        return solveTab(price,size,n,n);
        
    }
    public static int solveRec(int price[],int size[],int n,int s){
        //Base Case ::
        if(n==0 || s==0) return 0;
        
        if(size[n-1]>s){
            return solveRec(price,size,n-1,s);
        }else{
            return Math.max(price[n-1]+solveRec(price,size,n,s-size[n-1]),solveRec(price,size,n-1,s));
        }
    }
    public static int solveMemo(int price[],int size[],int n,int s,int[][] memo){
        if(n==0 || s==0) return 0;
        if(memo[n][s]!=-1){
            return memo[n][s];
        }
        if(size[n-1]>s){
            return memo[n][s]=solveMemo(price,size,n-1,s,memo);
        }else{
            return memo[n][s]=Math.max(price[n-1]+solveMemo(price,size,n,s-size[n-1],memo),solveMemo(price,size,n-1,s,memo));
        }
    }
    public static int solveTab(int price[],int size[],int n,int s){
        //Table ::
        int tab[][] = new int[n+1][n+1];
        //base - initlisation::automatic since default value is 0
        for(int i=1;i<n+1;i++){
            for(int j=1;j<s+1;j++){
                if(size[i-1]>j){
                    tab[i][j] =tab[i-1][j];
                }else{
                    tab[i][j] =Math.max(price[i-1]+tab[i][j-size[i-1]],tab[i-1][j]);
                }
            }
        }
        return tab[n][s];
    }
}