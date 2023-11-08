//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            int n = Integer.parseInt(read.readLine());
            String input[] = read.readLine().split(" ");
            
            int arr[] = new int[n];
            for(int i = 0;i<n;i++){
                arr[i] = Integer.parseInt(input[i]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.countTriplet(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int countTriplet(int arr[], int n) {
        // code here
        // HashSet<Integer> set = new HashSet<>();
        // for(int ele:arr){
        //     set.add(ele);
        // }
        // int cnt=0;
        // for(int i=0;i<n;i++){
        //     for(int j=i+1;j<n;j++){
        //         int val=arr[i]+arr[j];
        //         if(set.contains(val)){
        //             cnt++;
        //         }
        //     }
        // }
        // return cnt;
        // TC : O(n^2) 
        // SC : O(n)
        
        int cnt=0;
        Arrays.sort(arr);
        for(int i=n-1;i>=0;i--){
            int s =0;
            int e =i-1;
            while(s<e){
                int temp=arr[i];
                int dummy =arr[s]+arr[e];
                if(temp==dummy){
                    cnt++;
                    s++;
                    e--;
                }else if(dummy>temp){
                    e--;
                }else{
                    s++;
                }
            }
        }
        return cnt;
        // TC : O(nlogn) +O(n^2)
        // SC : O(1)
    }
}