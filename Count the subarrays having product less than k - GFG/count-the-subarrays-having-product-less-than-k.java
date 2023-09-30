//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


class GFG {
	public static void main(String[] args) throws IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(stt.nextToken());
            long k = Long.parseLong(stt.nextToken());
            
            long a[] = new long[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            Solution obj = new Solution();
            out.println(obj.countSubArrayProductLessThanK(a, n, k));
        }
        out.close();
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution {
    
    public long countSubArrayProductLessThanK(long a[], int n, long k)
    {
        //Broute Force :: 
        // TC : O(n^2)
        // SC : O(1)
        
        
        //Lets apply Sliding Window ::
        //TC : O(n)
        //SC :O(1)
        
        // int start=0;
        // int end=0;
        // long count=0,product=1;
        // while(end<(long)n){
        //     product*=a[end];
        //     if(product<k){
        //         count+=end-start+1;
        //         end++;
        //     }else{
        //         while(product>k && start<=end){
        //             product/=a[start];
        //             start++;
        //         }
        //         if(product<k){
        //             count+=end-start+1;
        //         }
        //         end++;
        //     }
        // }
        //return count;
        int start=0;
        int end=0;
        long count=0, product=1;
        while(end<(long)n){
            product*=a[end];
            while(product>=k && start<=end){
                product/=a[start];
                start++;
            }
            count+=end-start+1;
            end++;
        }
        return count;
    }
}