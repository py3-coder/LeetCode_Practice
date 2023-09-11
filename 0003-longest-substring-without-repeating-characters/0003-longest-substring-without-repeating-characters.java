class Solution {
    public int lengthOfLongestSubstring(String s) {
        //Sliding Window--Template ---Varibale Size window....
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