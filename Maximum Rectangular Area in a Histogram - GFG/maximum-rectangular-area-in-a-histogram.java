//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new Solution().getMaxArea(arr, n));
		}
	}
}




// } Driver Code Ends


class Solution
{
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long arr[], long n) 
    {
        // your code here
        //Lets Play with Stack::::
        long[] right=nsr(arr);
        long[] left =nsl(arr);
        
        //NSR , NSL ::
       
        long width=0;
        long maxi=0;
        for(int i=0;i<arr.length;i++){
            width =right[i]-left[i]-1;
            maxi =Math.max(width*arr[i],maxi);
        }
        return maxi;
    }
    public static long[] nsr(long[] arr){
        Stack<Integer> st = new Stack();
        long[] right=new long[arr.length];
         for(int i=arr.length-1;i>=0;i--){
            if(st.isEmpty()){
                right[i] =arr.length;
            }else if(arr[st.peek()]<arr[i]){
                right[i] =st.peek();
            }else{
                while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                    st.pop();
                }
                if(st.isEmpty()){
                    right[i] =arr.length;
                }else{
                    right[i] =st.peek();
                }
            }
            st.push(i);
        }
        return right;
    }
    public static long[] nsl(long[] arr){
        long[] left = new long[arr.length];
        Stack<Integer> st = new Stack();
        for(int i=0;i<arr.length;i++){
            if(st.isEmpty()){
                left[i] =-1;
            }else if(arr[st.peek()]<arr[i]){
                left[i] =st.peek();
            }else{
                while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                    st.pop();
                }
                if(st.isEmpty()){
                    left[i] =-1;
                }else{
                    left[i] =st.peek();
                }
            }
            st.push(i);
        }
        return left;
    }
        
}



