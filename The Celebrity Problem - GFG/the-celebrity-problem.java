//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java


class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
    	// Approch 1: if a is celebrity this its row is compelet 0 and it colum should all have 1
    	// except the [a,a] pos:
    	// Broute Force:: TC: O(n^2) SC: O(1)
    	
    	
    	// Let trye tioptimised::
    	// Using Stack:: Insert all candidates
    	// and check a know b & b knows a 
    	
    	Stack<Integer> st = new Stack<>();
    	
    	for(int i=0;i<n;i++){
    	    st.push(i);
    	}
    	
    	while(st.size()>1){
    	    int a =st.pop();
    	    int b =st.pop();
    	    
    	    if(M[a][b]==1){
    	        // a knows b
    	        st.push(b);
    	    }
    	    else{
    	        //b knows a::
    	        st.push(a);
    	    }
    	}
    	int ans=st.peek();
    	for(int i=0;i<n;i++){
    	    if(M[ans][i]==1 || M[i][ans]==0 && i!=ans){
    	        return -1;
    	    }
    	}
    	return ans;
    }
}