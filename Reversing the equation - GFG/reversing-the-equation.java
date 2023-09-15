//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        while(t-- > 0)
        {
            String s;
            s = in.readLine().trim();
            
            Solution ob = new Solution();
            
            out.println(ob.reverseEqn(s));    
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
   
    String reverseEqn(String S)
    {
        // your code here
        StringBuilder sb = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        Stack<String> s = new Stack<>();
        for(int i=0;i<S.length();i++){
            char ch =S.charAt(i);
            if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                s.push(ans.toString());
                s.push(Character.toString(ch));
                ans.setLength(0);
            }else{
                ans.append(ch);
            }
        }
        s.push(ans.toString());
        while(!s.isEmpty()){
            sb.append(s.pop());
        }
        return sb.toString();
    }
}