//{ Driver Code Starts
//Initial Template for Java


import java.util.*; 
import java.io.*; 

class GFG 
{ 
	public static void main (String[] args) { 
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
        	int n = sc.nextInt();
            int array[] = new int[n];
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }

            Solution ob = new Solution();

            int ans[] = ob.help_classmate(array,n);

           	for (int i=0; i<n; i++) 
                System.out.print(ans[i]+" "); 
            System.out.println();
            t--;
        }
	} 
} 


// } Driver Code Ends


//User function Template for Java

class Solution {
	public static int[] help_classmate(int arr[], int n) 
	{ 
	    // Your code goes here
	    //Lets Play with Stack::: why stack ::
	    // broute force :: 
	    // for(int i=0;i<n;i++){
	   //  for(int j=i-1;j>=0;j--){}  --since j is dependent on i -------think of stack:::   
	    //}
	    
	    int[] res = new int[arr.length];
	    Stack<Integer> st = new Stack<>();
	    for(int i=n-1;i>=0;i--){
	        if(st.isEmpty()){
	            res[i] =-1;
	        }else if(st.peek()<arr[i]){
	            res[i] =st.peek();
	        }else{
	            while(!st.isEmpty() && st.peek()>=arr[i]){
	                st.pop();
	            }
	            if(st.isEmpty()){
	                res[i] =-1;
	            }else{
	                res[i] =st.peek();
	            }
	        }
	        st.push(arr[i]);
	    }
	    return res;
	} 
}
