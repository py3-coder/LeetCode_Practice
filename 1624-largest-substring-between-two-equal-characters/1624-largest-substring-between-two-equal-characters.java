class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        HashMap<Character,Integer> map =new HashMap<>();
        int mini =-1;
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                mini = Math.max(i-map.get(s.charAt(i))-1,mini);
            }
            else map.put(s.charAt(i),i);
        }
        
        return mini;
    }
}