//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            ArrayList<Long> ans = new Solution().nthRowOfPascalTriangle(n);
            printAns(ans);
        }
    }
    public static void printAns(ArrayList<Long> ans) {
        for (Long x : ans) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    ArrayList<Long> nthRowOfPascalTriangle(int n) {
        // code here
        ArrayList<Long> ans=new ArrayList<>();
        Long t=1L;
        ans.add(t);
        Long mod=(long) (1000000000+7);
        
        for(int i=1;i<n;i++){
            t= ( (t%mod) * ((n-i)%mod) ) % mod;
            //for (a/b)%m ==>  (a * (b^-1) ) % m
            // t= ( (t%mod) / (i%mod) ) % mod ; //THIS IS WRONG
            t= ( (t%mod) * ( modInverse(i,mod) )  ) % mod ;
            ans.add(t%mod);
    }
    return ans;
    }
     public static long modInverse(long x,long M){
         return binexp(x,M-2,M);
    }
    public static long binexp(long a,long b,long m){
        long ans=1;
        while(b>0){
            if((b&1) == 1 ){ //mtlb odd
                ans= (ans*a) % m ;
                b--;
            }
            a=(a*a) %m ;
            b>>=1;
        }
        return ans;
    }
}