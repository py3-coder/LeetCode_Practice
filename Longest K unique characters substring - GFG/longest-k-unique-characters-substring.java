//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        int n=s.length();
        int res =0;
        HashMap<Character,Integer> map = new HashMap<>();
        int start=0,end=0;
        while(end<n){
            char ch  = s.charAt(end);
            map.put(ch,map.getOrDefault(ch,0)+1);
            if(map.size()<k){
                end++;
            }
            else if(map.size()==k){
                res= Math.max(res,end-start+1);
                end++;
            }else{
                while(map.size()>k){
                    char ss = s.charAt(start);
                    map.put(ss,map.get(ss)-1);
                    if(map.get(ss)==0){
                        map.remove(ss);
                    }
                    start++;
                }
                end++;
            }
        }
        return res;
    }
    
}