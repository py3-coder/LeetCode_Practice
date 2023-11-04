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
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}
// } Driver Code Ends




//User function Template for Java

// class Solution{
//     static int memo[][] = new int[501][501];
//     static int palindromicPartition(String str)
//     {
//         // Lets Play with MCM DP:)
//         //1. Recursion::
//         //return solveRec(str,0,str.length()-1);
        
//         Arrays.stream(memo).forEach(a->Arrays.fill(a,-1));
//         return solveMemo(str,0,str.length()-1);
//     }
//     static int solveRec(String str,int i,int j){
//         if(i>=j) return 0;
//         if(isPalindrome(str,i,j)){
//             return 0;
//         }
//         int ans=Integer.MAX_VALUE;
//         for(int k=i;k<j;k++){
//             int temp=1+solveRec(str,i,k)+solveRec(str,k+1,j);
//             if(temp<ans){
//                 ans=temp;
//             }
//         }
//         return ans;
//     }
//     static boolean isPalindrome(String str,int i,int j){
//         if(j-i<=1){
//             return true;
//         }
//         String ac =str.substring(i,j+1);
//         String rev="";
//         for(char ch: ac.toCharArray()){
//             rev =ch+rev;
//         }
//         if(ac.equals(rev)){
//             return true;
//         }
//         return false;
//     }
//     static int solveMemo(String str,int i,int j){
//         if(i>=j) return 0;
//         if(memo[i][j]!=-1){
//             return memo[i][j];
//         }
//         if(isPalindrome(str,i,j)){
//             return memo[i][j]=0;
//         }
//         int ans=Integer.MAX_VALUE;
//         // 
//         for(int k=i;k<=j-1;k++)
//         {
//             //int temp=1+help(str,i,k,dp)+help(str,k+1,j,dp);
//             int left=0,right=0;
//             if(memo[i][k]!=-1)    left=memo[i][k];
//             else
//             {
//                 left=solveMemo(str,i,k);
//                 memo[i][k]=left;
//             }
//             if(memo[k+1][j]!=-1)    right=memo[k+1][j];
//             else
//             {
//                 right=solveMemo(str,k+1,j);
//                 memo[k+1][j]=right;
//             }
//             int temp=1+right+left;
//             if(temp<ans)
//             {
//                 ans=temp;
//             }
//         }
//         return memo[i][j]=ans;
//     }
// }
class Solution{
    static int [][]dp = new int[500+1][500+1];
    static int palindromicPartition(String str)
    {
        // code here
        
        for(int []row : dp){
            Arrays.fill(row,-1);
        }
        int n = str.length();
        int i = 0;
        int j = (n-1);
        
        int res = solve(str,i,j);
        return res;
    }
    public static int solve(String s, int i , int j){
        
        if(i>=j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(ispalindrome(s,i,j)){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for(int k = i;k<j;k++){
            int left,right;
            if(dp[i][k]!=-1){
                left = dp[i][k];
            }else{
                dp[i][k] = left = solve(s,i,k);
            }
            if(dp[k+1][j]!=-1){
                right = dp[k+1][j];
            }else{
                dp[k+1][j] = right = solve(s,k+1,j);
            }
            int temp_ans = 1+left+right;
            min = Math.min(min,temp_ans);
        }
        return dp[i][j]=min;
    }
    public static boolean ispalindrome(String s, int i, int j){
        boolean bool = true;
        int n = s.length();
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                bool = false;
                break;
            }
            i++;
            j--;
        }
        return bool;
    }
}