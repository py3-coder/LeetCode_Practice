//{ Driver Code Starts
//Initial Template for Java




import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            String ans = new Solution().solve(arr, n);
            System.out.println(ans);
        }
    }
}


// } Driver Code Ends


//User function Template for Java





class Solution {
    String solve(int[] arr, int n) {
        // code here
        if(n==1) return String.valueOf(arr[0]);
        Arrays.sort(arr);
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();
        for(int i=0;i<n;i++){
            if(i%2==0){
                num1.append(arr[i]);
            }else{
                num2.append(arr[i]);
            }
        }
        StringBuilder ans = new StringBuilder();
        int carry=0;
        int s1=num1.length()-1;
        int s2=num2.length()-1;
        while(s1>=0 && s2>=0){
            int a = num1.charAt(s1)-'0';
            int b =num2.charAt(s2)-'0';
            int sum = a+b+carry;
            ans.append(sum%10);
            carry = sum/10;
            s1--;
            s2--;
        }
        if(n%2!=0){
            int c= carry+(num1.charAt(0)-'0');
            if(c>0) ans.append(c);
        }else{
            if(carry>0) ans.append(carry);
        }
        ans=ans.reverse();
        int i=0;
        int len=ans.length();
        while(i<len && ans.charAt(i)=='0')i++;
        return i==len?"0":ans.substring(i).toString();
    }
}
