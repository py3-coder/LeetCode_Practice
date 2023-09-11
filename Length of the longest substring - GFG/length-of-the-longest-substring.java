//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String s = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubsttr(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution{
    int longestUniqueSubsttr(String S){
        //Sliding Window Technique -- Variable length window :::
        int n=S.length();
        int res=0;
        int start=0,end=0;
        HashMap<Character,Integer> map = new HashMap<>();
        while(end<n){
            char ch = S.charAt(end);
            map.put(ch,map.getOrDefault(ch,0)+1);
            if(end-start+1<map.size()){
                end++;
            }else if(end-start+1==map.size()){
                res = Math.max(res,end-start+1);
                end++;
            }else if(end-start+1>map.size()){
                while(end-start+1>map.size()){
                    char ss = S.charAt(start);
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