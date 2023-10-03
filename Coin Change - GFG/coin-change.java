//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sum = sc.nextInt();
            int N = sc.nextInt();
            int coins[] = new int[N];
            for (int i = 0; i < N; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}


// } Driver Code Ends


// User function Template for Java

class Solution {
    static long[][] memo =new long[1001][1001];
    public long count(int coins[], int N, int sum) {
        // code here.
        //1. Recursion::
        // TC : O(2^n) SC : O(1)
        //return solveRec(coins,N,sum);
        
        //2.Memo ::
        // TLE : 235/1120
        //TC : O(n*sum)
        //SC :O(1)
        // Arrays.stream(memo).forEach(a->Arrays.fill(a,-1));
        // return solveMem(coins,N,sum);
        
        //3. Tabulation::
        return solveTab(coins,N,sum);
    }
    public long solveRec(int coins[],int n,int sum){
        if(sum==0) return 1;
        if(n==0) return 0;
        
        if(coins[n-1]>sum){
            return solveRec(coins,n-1,sum);
        }else{
            return solveRec(coins,n,sum-coins[n-1])+solveRec(coins,n-1,sum);
        }
    }
    public long solveMem(int coins[],int n,int sum){
        if(sum==0) return 1;
        if(n==0) return 0;
        
        if(memo[n][sum]!=-1){
            return memo[n][sum];
        }
        if(coins[n-1]>sum){
            return memo[n][sum]=solveMem(coins,n-1,sum);
        }else{
            return memo[n][sum]=solveMem(coins,n,sum-coins[n-1])+solveMem(coins,n-1,sum);
        }
    }
    public long solveTab(int coins[],int n,int sum){
        //Tabulation::
        long tab[][] = new long[n+1][sum+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<sum+1;j++){
                if(i==0) tab[i][j]=0;
                if(j==0) tab[i][j]=1;
            }
        }
        //
        for(int i=1;i<n+1;i++){
            for(int j=0;j<sum+1;j++){
                if(coins[i-1]>j){
                    tab[i][j] = tab[i-1][j];
                }else{
                    tab[i][j] =tab[i][j-coins[i-1]]+tab[i-1][j];
                }
            }
        }
        return tab[n][sum];
    }
}