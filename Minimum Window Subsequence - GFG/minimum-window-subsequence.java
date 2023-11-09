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
            String s1 = sc.next();
            String s2 = sc.next();
            Solution obj = new Solution();
            String ans = obj.minWindow(s1, s2);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static String minWindow(String str1, String str2) {
        // code here
        int s1 =0,s2=0,s1len=str1.length(),s2len=str2.length();
        int start=0;
        int end=0;
        int minlen=10002;
        String minstr="";
        while(s1<s1len && s2<s2len){
            //Match the chars::
            if(str1.charAt(s1)==str2.charAt(s2)){
                if(s2==s2len-1){
                    end=s1;
                    while(s2>=0){
                        if(str2.charAt(s2)==str1.charAt(s1)){
                            s2--;
                        }
                        s1--;
                    }
                    start=s1+1;
                    if(minlen>end-start+1){
                        minlen=end-start+1;
                        minstr=str1.substring(start,end+1);
                    }
                    s1=s1+1;
                    s2=0;
                }
                else s2++;
            }
            s1++;
        }
        return minlen==10002?"":minstr;
    }
}
