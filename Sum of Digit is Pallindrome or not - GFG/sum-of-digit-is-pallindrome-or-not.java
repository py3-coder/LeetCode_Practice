//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.isDigitSumPalindrome(N));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int isDigitSumPalindrome(int num) {
        // code here
        int sum=0;
        while(num>0){
            sum +=num%10;
            num/=10;
        }
        return isPalindrome(sum)==true?1:0;
    }
    public static boolean isPalindrome(int sum){
        int temp =sum;
        int num =0;
        while(sum>0){
            int last = sum%10;
            num =num*10+last;
            sum/=10;
        }
        if(num==temp){
            return true;
        }else{
            return false;
        }
    }
}