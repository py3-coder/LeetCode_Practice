//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.maxOnes(a, n));
            
        }
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution {

    public static int maxOnes(int a[], int n) {
        // Your code goes here
        //Kadane Approch 
        int max_so_far=0;
        int max_end=0;
        int count=0;
        for(int i=0;i<n;i++){
            if(a[i]==1){
                count++;
            }
            int val =(a[i]==0)?1:-1;
            max_end =Math.max(val,max_end+val);
            max_so_far=Math.max(max_so_far,max_end);
        }
        max_so_far=Math.max(0,max_so_far);
        return max_so_far+count;
    }
}
