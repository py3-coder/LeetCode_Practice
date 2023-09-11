class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        
        HashMap<Character,Integer> map = new HashMap<>();
        for(int m=0;m<p.length();m++){
            char ch =p.charAt(m);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int count=map.size();
        int i=0,j=0;
        while(j<s.length()){
            char ch = s.charAt(j);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)==0){
                    count--;
                }
            }
            if(j-i+1<p.length()) j++;
            else if(j-i+1==p.length()){
                if(count==0){
                    res.add(i);
                }
                char ss = s.charAt(i);
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