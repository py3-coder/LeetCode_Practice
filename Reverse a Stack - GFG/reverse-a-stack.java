//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        PrintWriter out=new PrintWriter(System.out);
        
        //taking testcases
        int t = Integer.parseInt(br.readLine()); 
    	for(int i=0;i<t;i++)
    	{
            String str=br.readLine();
    		
    		//input n and d
    	    int n=Integer.parseInt(str);
    		Stack<Integer> stack=new Stack<>();
    		String str1=br.readLine();
    		String[] starr1=str1.split(" ");
    		//inserting elements in the array
    		for(int j=0;j<n;j++)
    		{
    		    stack.push(Integer.parseInt(starr1[j]));
    		}
    		//calling reverse() function
            Solution.reverse(stack);
            for(int j:stack){
                out.print(j+" ");
            }
            out.println();
         }
         out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{ 
    static void reverse(Stack<Integer> s)
    {
        // 1. Approch : Use 2 stack :: Simple::
        // TC : O(n)+O(n) , SC :O(n)
        
        //2. Recursion ::
        // TC :O(n) SC : O(1)+O(n)~  Recursion Stack::
        solveRec(s);
        
    }
    public static void solveRec(Stack<Integer> st){
        //Base Case ::
        if(st.size()==1) return ;
        
        int val = st.pop();
        solveRec(st);
        insert(st,val);
    }
    public static void insert(Stack<Integer> st,int val){
        if(st.isEmpty()){
            st.push(val);
            return ;
        }

        int temp=st.pop();
        insert(st,val);
        st.push(temp);
    }
}