//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            sc.nextLine();
            String s = sc.next();
            Solution obj = new Solution();
            String ans = obj.preToInfix(s);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static String preToInfix(String pre_exp) {
        
        return solve(pre_exp);
        // code here
    }
    public static String solve(String exp){
        Stack<String> st = new Stack<>();
        
        for(int i=exp.length()-1;i>=0;i--){
            char ch =exp.charAt(i);
            if(isOperator(ch)){
                String op1=st.pop();
                String op2=st.pop();
                String temp ='('+op1+ch+op2+')';
                st.push(temp);
            }else st.push(String.valueOf(ch));
        }
        return st.peek();
    }
    public static boolean isOperator(char s){
        if(s=='+' || s=='/' || s=='-' || s=='*' || s=='^') return true;
        return false;
    }
    
}
