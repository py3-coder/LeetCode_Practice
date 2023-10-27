//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = Integer.parseInt(sc.next());
        while(t>0)
        {
            int n = Integer.parseInt(sc.next());
            Solution T = new Solution();
            List<String> ans = T.AllParenthesis(n);
            String[] sequences = ans.toArray(new String[0]);
            Arrays.sort(sequences);
            int k = sequences.length;
            for(int i=0;i<k;i++)
            {
                System.out.println(sequences[i]);
            }
            
            t--;
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public List<String> AllParenthesis(int n) 
    {
        // Write your code here
        List<String> res = new ArrayList<>();
        solveRec(n,n,"",res);
        return res;
    }
    public static void solveRec(int open,int close,String op,List<String> res){
        //Base Case::
        if(open==0 && close==0){
            res.add(op);
            return;
        }
        
        if(open==close){
            String Op1=op+'(';
            solveRec(open-1,close,Op1,res);
        }
        if(open<close){
            if(open==0 && close!=0){
                String Op2 =op+')';
                solveRec(open,close-1,Op2,res);
            }else{
                String Op1 =op+'(';
                String Op2 =op+')';
                solveRec(open-1,close,Op1,res);
                solveRec(open,close-1,Op2,res);
            }
            
           
        }
    }
}