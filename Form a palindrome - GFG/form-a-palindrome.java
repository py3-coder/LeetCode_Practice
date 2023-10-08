//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            
            String S = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.findMinInsertions(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int findMinInsertions(String S){
        // Lets Play with DP:)
        String rev="";
        for(char ch: S.toCharArray()){
            rev =ch+rev;
        }
        return solveTabLCS(S,rev);
    }
    // LPS --> LCS(a,rev(a))::
    // S.length-LPS = (No. of insertion/deletion)
    public static int solveTabLCS(String S1,String S2){
        // Tabulation::
        int n=S1.length();
        int tab[][] = new int[n+1][n+1];
        //Initlisation:: Default Value ->0:
        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                if(S1.charAt(i-1)==S2.charAt(j-1)){
                    tab[i][j] = 1+tab[i-1][j-1];
                }else{
                    tab[i][j] =Math.max(tab[i][j-1],tab[i-1][j]);
                }
            }
        }
        return S1.length()-tab[n][n];
    }
}