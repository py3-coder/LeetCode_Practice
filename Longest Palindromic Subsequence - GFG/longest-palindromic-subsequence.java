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
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.longestPalinSubseq(s));
                }
                
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int longestPalinSubseq(String S)
    {
        //Lets Play With DP:)
        String rev="";
        for(char ch: S.toCharArray()){
            rev =ch+rev;
        }
        int n=S.length();
        return solveTabLCS(S,rev,n,n);
        
        
    }
    public static int solveTabLCS(String X,String Y,int n,int m){
        // Tabulation::
        
        int tab[][] = new int[n+1][m+1];
        //Base case by default handle::
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(X.charAt(i-1)==Y.charAt(j-1)){
                    tab[i][j]=1+tab[i-1][j-1];
                }else{
                    tab[i][j]= Math.max(tab[i-1][j],tab[i][j-1]);
                }
            }
        }
        return tab[n][m];
    }
}