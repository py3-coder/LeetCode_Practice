class Solution {
    public int numberOfSubstrings(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int start =0,end=0;
        int res=0;
        while(end<s.length()){
            char ch =s.charAt(end);
            map.put(ch,map.getOrDefault(ch,0)+1);
            while(map.size()>=3){
                char ss =s.charAt(start);
                map.put(ss,map.get(ss)-1);
                if(map.get(ss)==0){
                    map.remove(ss);
                }
                start++;
            }
            res+=start;
            end++;
        }
        return res;
    } 
}