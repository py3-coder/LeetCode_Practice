//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new Solution().smallestWindow(s, t));
		    test--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String s, String p)
    {
        //Sliding Window::
        int res = Integer.MAX_VALUE;
        HashMap<Character,Integer> map =new HashMap<>();
        for(char ch:p.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        
        int start=0,fend=0,fstart=0;
        int end=0;
        int k=map.size();
        while(end<s.length()){
            char ch =s.charAt(end);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)==0){
                    k--;
                }
            }
            if(k>0){
                end++;
            }else if(k==0){
                while(k==0){
                    if(res>end-start+1){
                        res=end-start+1;
                        fstart=start;
                        fend=end;
                    }
                    char st =s.charAt(start);
                    if(map.containsKey(st)){
                        map.put(st,map.get(st)+1);
                        if(map.get(st)==1){
                            k++;
                        }
                    }
                    start++;
                }
                end++;
            }
        }
        if(res>s.length())  return "-1";   
        return s.contains(s.substring(fstart,fend+1))?s.substring(fstart,fend+1):"";
        
    }
}