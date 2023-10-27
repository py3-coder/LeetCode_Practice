//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(
                new Solution().infixToPostfix(br.readLine().trim()));
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to convert an infix expression to a postfix expression.
    public static String infixToPostfix(String exp) {
        
        // Your code here
        return solve(exp);
    }
    public static String solve(String exp){
        Stack<Character> st = new Stack<>();
        String ans="";
        
        for(int i=0;i<exp.length();i++){
            char ch =exp.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                ans+=ch;
            }else if(ch=='('){
                st.push(ch);
            }else if(ch==')'){
                while(!st.isEmpty() && st.peek()!='('){
                    ans+=st.pop();
                }
                st.pop();
            }else{
                while(!st.isEmpty() && precedence(ch)<=precedence(st.peek())){
                    ans+=st.pop();
                }
                st.push(ch);
            }
        }
        
        while(!st.isEmpty()){
            ans+=st.pop();
        }
        return ans;
        
        
    }
    public static int precedence(char ch){
        switch(ch){
            case('+'):
            case('-'):
            return 1;
            
            case('*'):
            case('/'):
            return 2;
            
            case('^'):
            return 3;
        }
        return -1;
    }
}