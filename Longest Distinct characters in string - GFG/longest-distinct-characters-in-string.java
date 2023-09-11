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
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestSubstrDistinctChars(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int longestSubstrDistinctChars(String s){
        // code here
        int n=s.length();
        int res =0;
        HashMap<Character,Integer> map = new HashMap<>();
        int start =0;
        int end=0;
        while(end<n){
            char ch = s.charAt(end);
            map.put(ch,map.getOrDefault(ch,0)+1);
            if(end-start+1<map.size()){
                end++;
            }
            else if(end-start+1==map.size()){
                res=Math.max(res,end-start+1);
                end++;
            }else if(end-start+1>map.size()){
                while(end-start+1>map.size()){
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