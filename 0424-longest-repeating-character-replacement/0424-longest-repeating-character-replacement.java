class Solution {
    public int characterReplacement(String s, int k) {
        int n=s.length();
        int res=0;
        HashMap<Character,Integer> map  = new HashMap<>();
        int start=0,end=0;
        
        while(end<n){
            char ch = s.charAt(end);
            map.put(ch,map.getOrDefault(ch,0)+1);
            int mostFrequentCharacter=Collections.max(map.values());
            // count of letter change => (end-start+1)-mostFrequentCharacter ><=k threecase::
            if((end-start+1)-mostFrequentCharacter<k){
                end++;
            }else if((end-start+1)-mostFrequentCharacter==k){
                res=Math.max(res,end-start+1);
                end++;
            }else{
                while((end-start+1)-mostFrequentCharacter>k){
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
        return res==0?s.length():res;
    }
}