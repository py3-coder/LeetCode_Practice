class Solution {
    public int findTheLongestSubstring(String s) {
        // Sliding window won't work here :-
        // think once --- 
        // Bit manupulation logic 
        /// super question ----
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('a',0);
        map.put('e',1);
        map.put('o',2);
        map.put('i',3);
        map.put('u',4);
        
        HashMap<Integer,Integer> posMap = new HashMap<>();
        posMap.put(0,-1);
        
        int curr =0;
        int maxi =0;
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
            int pos = map.get(s.charAt(i));
            curr = curr^(1<<pos);
            }
            
            if(posMap.containsKey(curr)){
                maxi = Math.max(maxi , i-posMap.get(curr));
            }else{
                posMap.put(curr , i);
            }
        }
        return maxi ;
    }
}