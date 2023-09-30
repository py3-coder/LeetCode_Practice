//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(stt.nextToken());
            int m = Integer.parseInt(stt.nextToken());
            int k = Integer.parseInt(stt.nextToken());
            int a[] = new int[(int)(n)];
            int b[] = new int[(int)(m)];
            
            
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(inputLine1[i]);
            }
            
            
            Solution obj = new Solution();
            System.out.println(obj.kthElement( a, b, n, m, k));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        
        //Concept :: Merge Sort ::
        // TC: O(k)
        //SC :O(1)
        // long ans=0;
        // int l=0;
        // int r=0;
        // int count=0;
        // while(l<n && r<m ){
        //     if(count==k) break;
        //     else if(arr1[l]<arr2[r]){
        //         ans =arr1[l];
        //         ++l;
        //     }else {
        //         ans =arr2[r];
        //         ++r;
        //     }
        //     ++count;
        // }
        // if(count!=k){
        //     if(l!=n-1){
        //         ans =arr1[k-count];
        //     }else{
        //         ans =arr2[k-count];
        //     }
        // }
        // return ans;
        
        if(n>m) return kthElement(arr2,arr1,m,n,k);
        int left =k;
        int low=Math.max(0,k-m),high=Math.min(k,n);
        while(low<=high){
            int mid1 = low+(high-low)/2;
            int mid2 = k-mid1;

            long l1 =(mid1>0)?arr1[mid1-1]:Long.MIN_VALUE;
            long l2 =(mid2>0)?arr2[mid2-1]:Long.MIN_VALUE;
            long r1 =(mid1<n)?arr1[mid1]:Long.MAX_VALUE;
            long r2 =(mid2<m)?arr2[mid2]:Long.MAX_VALUE;

            if(l1<=r2 && l2<=r1){
                return Math.max(l1,l2);
            }else if(l1>r2){
                high=mid1-1;
            }else{
                low =mid1+1;
            }
        }
        return 1;
    }
}