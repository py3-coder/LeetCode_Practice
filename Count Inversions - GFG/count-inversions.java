//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long inversionCount(long arr[], long N)
    {
        //Lets Play ::
        //Broute Force ::
        // TC :O(n^2);
        // SC O(1)
        
        // Why Merge Sort  :: --> :)
        return mergeSort(arr,0,(int)N-1);
    }
    public static long mergeSort(long arr[] , int low,int high){
        long cnt=0;
        if(low>=high) return cnt;
        int mid =low+(high-low)/2;
        cnt +=mergeSort(arr,low,mid);
        cnt +=mergeSort(arr,mid+1,high);
        cnt +=merge(arr,low,high,mid);
        
        return cnt;
    }
    public static long merge(long[] arr , int  low,int high,int mid){
        ArrayList<Long> res =new ArrayList<>();
        long count=0;
        int left =low;
        int right =mid+1;
        while(left<=mid && right<=high){
            if(arr[left]<=arr[right]){
                res.add(arr[left]);
                left++;
            }else{
                res.add(arr[right]);
                count+=(mid-left+1);
                right++;
            }
        }
        while(left<=mid){
            res.add(arr[left]);
            left++;
        }
        while(right<=high){
            res.add(arr[right]);
            right++;
        }
        for(int i=low;i<=high;i++){
            arr[i] =res.get(i-low);
        }
        return count;
    }
}