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
                    String s1 = sc.next();
                    String s2 = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperations(s1,s2));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
	public int minOperations(String str1, String str2) 
	{ 
	    // Your code goes here
	    return solveTabLCS(str1 , str2);
	} 
	public static int  solveTabLCS(String str1,String str2){
	    //Tabulation::
	    int n=str1.length();
	    int m=str2.length();
	    int tab[][] = new int[n+1][m+1];
	    
	    // Question is Like  X--> LCS -> Y:
	    //Base Case by default handle:0)
	    
	    for(int i=1;i<n+1;i++){
	        for(int j=1;j<m+1;j++){
	            if(str1.charAt(i-1)==str2.charAt(j-1)){
	                tab[i][j] = 1+tab[i-1][j-1];
	            }else{
	                tab[i][j] =Math.max(tab[i-1][j] ,tab[i][j-1]);
	            }
	        }
	    }
	    int delete=n-tab[n][m];
	    int insert=m-tab[n][m];
	 
	    return insert+delete;
	}
}