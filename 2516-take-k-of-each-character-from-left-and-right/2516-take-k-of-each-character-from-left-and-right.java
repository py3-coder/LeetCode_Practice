class Solution {
    public int takeCharacters(String s, int k) {
        int n = s.length();
        if(s.length() <k*3){
            return -1;
        }
        if(k==0){
            return 0;
        }
        
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch , map.getOrDefault(ch,0)+1);
        }
        
        if(map.getOrDefault('a',0)<k || map.getOrDefault('b',0)<k || map.getOrDefault('c',0)<k){
            return -1;
        }
                
        int ans = n;
        
        int start=0;
        int end=0;
        int window=0;
        while(end<s.length()){
            char ch =s.charAt(end);
            map.put(ch, map.get(ch)-1);
            window++;
            
            while(map.get(ch)<k){
                char st =s.charAt(start);
                map.put(st, map.get(st)+1);
                window--;
                start++;
            }
            ans = Math.min(ans  , n - window);
            end++;
        }
        return ans ;
    }
}