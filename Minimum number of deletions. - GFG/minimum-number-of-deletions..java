//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            int n = Integer.parseInt(read.readLine());
            String str = read.readLine().strip();
            Solution ob = new Solution();
            long ans = ob.minDeletions(str, n); 
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    int minDeletions(String str, int n)
    {
        //Lets Play With DP:)
        String rev="";
        for(char ch: str.toCharArray()){
            rev =ch+rev;
        }
        return solveTabLCS(str,rev,n,n);
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
        return X.length()-tab[n][m];
    }
} 