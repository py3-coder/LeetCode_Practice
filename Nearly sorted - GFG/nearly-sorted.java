//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int num = sc.nextInt();
            int k = sc.nextInt();
            
            int arr[] = new int[num];
            for(int i = 0; i < num; i++)
                arr[i] = sc.nextInt();
            
            ArrayList <Integer> res = new Solution().nearlySorted(arr, num, k);
            for (int i = 0; i < res.size (); i++)
                System.out.print (res.get (i) + " ");
            System.out.println();
        }
    }
}


// } Driver Code Ends


class Solution
{
    //Function to return the sorted array.
    ArrayList <Integer> nearlySorted(int arr[], int num, int k)
    {
        // Broute Force ::)
        //Just Do sortinh -> O(nlogn)::
        
        //Heap Question :)
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> minheap =new PriorityQueue<>();
        for(int ele:arr){
            minheap.add(ele);
            if(minheap.size()>k){
                res.add(minheap.poll());
            }
        }
        while(minheap.size()>0){
            res.add(minheap.poll());
        }
        return res;
    }
}
