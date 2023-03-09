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
            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int ans = new Solution().findKRotation(a, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int findKRotation(int arr[], int n) {
        // code here
        int start =0;
        int end =n-1;
        while(start<=end){
            int mid =start +(end-start)/2;
            //Check is this is the min ele
            int next = (mid+1)%n;
            int prev = (mid+n-1)%n;
            
            if(arr[mid]<arr[next] && arr[mid]<arr[prev]){
                return mid;
            }
            else if(arr[0]<=arr[mid]){
                start =mid+1;
            }else if(arr[mid]<=arr[n-1]){
                end = mid-1;
            }
        }
        return 0;
    }
}