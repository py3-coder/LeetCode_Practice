//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            long ans[] = obj.Series(n);
            for (long i : ans) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {

    long[] Series(int n) {
        // code here
    long[] res = new long[n+1];
    //   for(int i=0;i<=n;i++){
    //       res[i] =fibb(i);
    //   }
    //   return res;
    res[0] =0;
    res[1] =1;
    int indx =2;
    fibbo(res,n,indx);
    
    return res;
        
    }
    public static long fibb(int n){
        if(n==0) {
            return 0;
        }
        if(n==1) {
            return 1;
        }
        return fibb(n-1)+fibb(n-2);
    }
    public static void fibbo(long[] res,int n,int i){
        if(i>n) return;
        res[i] =res[i-1]+res[i-2];
        fibbo(res,n,i+1);
    }
}