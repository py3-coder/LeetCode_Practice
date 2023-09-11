//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String txt = br.readLine().trim();
            String pat = br.readLine().trim();

            int ans = new Solution().search(pat, txt);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int search(String pat, String txt) {
        // code here
        int res=0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<pat.length();i++){
            char ch =pat.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int count=map.size();
        int i=0,j=0;
        while(j<txt.length()){
            char ch = txt.charAt(j);
            if(map.containsKey(ch)){
                map.put(ch , map.get(ch)-1);
                if(map.get(ch)==0){
                    count--;
                }
            }
            if(j-i+1<pat.length()) j++;
            else if(j-i+1==pat.length()){
                if(count==0){
                    res++;
                }
                char ss =txt.charAt(i);
                if(map.containsKey(ss)){
                    if(map.get(ss)==0){
                        count++;
                    }
                map.put(ss,map.get(ss)+1);
                }
                i++;
                j++;
            }
        }
        return res;
    }
}