//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String[] args) {

        // Taking input using class Scanner
        Scanner sc = new Scanner(System.in);

        // Taking count of total testcases
        int t = sc.nextInt();

        while (t-- > 0) {
            int n, m;

            // taking count of elements in array a
            n = sc.nextInt();

            // taking count of elements in array b
            m = sc.nextInt();

            // Creating 2 arrays of n and m
            int a[] = new int[n];
            int b[] = new int[m];

            // inserting elements to array a
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            // inserting elements to array b
            for (int i = 0; i < m; i++) {
                b[i] = sc.nextInt();
            }
            Solution ob = new Solution();
            // calling NumberofElementsInIntersection method
            // and printing the result
            System.out.println(ob.NumberofElementsInIntersection(a, b, n, m));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to return the count of the number of elements in
    // the intersection of two arrays.
    public static int NumberofElementsInIntersection(int a[], int b[], int n, int m) {
        // Your code here
        // Broute Force ::
        // HashMap Approch :) 
        // TC : O(n+m)+O(n+m)
        // SC : O(n+m) 
        
        // HashSet :)
        // TC : O(n+m)
        // SC : O(n+m)
        
        Arrays.sort(a);
        Arrays.sort(b);
        int i=0,j=0;
        List<Integer> res =new ArrayList<>();
        while(i<n && j<m){
            if(a[i]==b[j]){
                if(res.isEmpty()||res.get(res.size()-1)!=a[i]){
                    res.add(a[i]);
                }
                i++;
                j++;
            }
            else if(a[i]>b[j]){
                j++;
            }else{
                i++;
            }
        }
        return res.size();
    }
};
