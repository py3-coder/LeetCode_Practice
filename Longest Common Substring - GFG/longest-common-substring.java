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
            String input[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            
            String S1 = read.readLine().trim();
            String S2 = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestCommonSubstr(S1, S2, n, m));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int longestCommonSubstr(String S1, String S2, int n, int m){
        // Recusrision is bit logical :: Handle With Care:
        //1. Recursion:: TLE :
        //return solveRec(S1,S2,n,m,0);
        //2 Memoisation:
        // Since We have 3 varible n,m ,length so we can't store in 2d matrix;
        // We need 3d dp::
        //better use hashmap::
        // HashMap<String,Integer> map = new HashMap<>();
        // return solveMemo(S1,S2,n,m,0,map);
        
        //3. Tabulation TOP-DOWN:
        return solveTab(S1,S2,n,m);
    }
    public static int solveRec(String S1,String S2,int n ,int m,int len){
        // Base::
        if(n==0 || m==0) return len;
        
        // last char are same we include it else:
        int ans2=0; int ans1=len;
        if(S1.charAt(n-1)== S2.charAt(m-1)){
            ans1 =solveRec(S1,S2,n-1,m-1,len+1);
        }
        ans2 =Math.max(solveRec(S1,S2,n-1,m,0),solveRec(S1,S2,n,m-1,0));
        return Math.max(ans1,ans2);
    }
    public static int solveMemo(String S1,String S2,int n ,int m,int len,HashMap<String,Integer> map){
        // Base::
        if(n==0 || m==0) return len;
        //check precamputed::
        String key=n+"f"+m+"s"+len;
        if(map.containsKey(key)){
            return map.get(key);
        }
        // last char are same we include it else:
        int ans2=0; int ans1=len;
        if(S1.charAt(n-1)== S2.charAt(m-1)){
            ans1 =solveMemo(S1,S2,n-1,m-1,len+1,map);
        }
        ans2 =Math.max(solveMemo(S1,S2,n-1,m,0,map),solveMemo(S1,S2,n,m-1,0,map));
        map.put(key,Math.max(ans1,ans2));
        return Math.max(ans1,ans2);
    }
    public static int solveTab(String S1,String S2,int n, int m){
        //Tabulation:: Similar to LCS-{LOngest Common Subsquence}:
        int tab[][] = new int[n+1][m+1];
        
        //base - intilization::
        //by defalut value are 0:
        int sol=0;
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(S1.charAt(i-1)==S2.charAt(j-1)){
                    tab[i][j] = 1+tab[i-1][j-1];
                    sol=Math.max(sol,tab[i][j]);
                }else{
                    tab[i][j] =0;
                }
            }
        }
        return sol;
        
    }
}