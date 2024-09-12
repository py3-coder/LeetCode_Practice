class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        for(char ch :allowed.toCharArray()){
            set.add(ch);
        }
        int cnt=0;
        for(String st : words){
            if(check(set,st)){
                cnt++;
            }
        }
        return cnt;
        
    }
    public boolean check(Set<Character> set , String test){
        for(char ch : test.toCharArray()){
            if(!set.contains(ch)){
                return false;
            }
        }
        return true;
    }
}