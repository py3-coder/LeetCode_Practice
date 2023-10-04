//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {

		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		while(test-- > 0){
		    int p=sc.nextInt();             // Take size of both the strings as input
		    int q=sc.nextInt();
		    
		    String s1=sc.next();            // Take both the string as input
	        String s2=sc.next();
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.lcs(p, q, s1, s2));
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to find the length of longest common subsequence in two strings.
    static int[][] memo = new int[1001][1001];
    static int lcs(int x, int y, String s1, String s2)
    {
        // Lets Play With Recursion to DP:)
        // 1.Recursion::
        // TC : O(2^(n+m)
        //return solveRec(x,y,s1,s2);
        
        //2. Memoization Call:
        Arrays.stream(memo).forEach(a->Arrays.fill(a,-1));
        return solveMemo(x,y,s1,s2);
    }
    static int solveRec(int n,int m,String s1,String s2){
        //Base Case::
        if(n==0 || m==0){
            return 0;
        }
         // If characters are the same, we can extend the subsequence length by 1
        if(s1.charAt(n-1)==s2.charAt(m-1)){
            return 1+solveRec(n-1,m-1,s1,s2);
        }else{
            // If characters are different, we have two choices:
            // 1. Exclude the last character of s1 and compare s1[0..n-2] with s2[0..m-1]
            // 2. Exclude the last character of s2 and compare s1[0..n-1] with s2[0..m-2]
            return Math.max(solveRec(n-1,m,s1,s2),solveRec(n,m-1,s1,s2));
        }
    }
    public static int solveMemo(int n,int m,String s1,String s2){
        //Base Case::
        if(n==0 || m==0){
            return 0;
        }
        //check pre computed::
        if(memo[n][m]!=-1){
            return memo[n][m];
        }
        //if char are same :: means we can +1 the subsequence length;
        if(s1.charAt(n-1)==s2.charAt(m-1)){
            return memo[n][m]=1+solveMemo(n-1,m-1,s1,s2);
        }else{
            return memo[n][m]=Math.max(solveMemo(n-1,m,s1,s2),solveMemo(n,m-1,s1,s2));
        }
    }
    
}