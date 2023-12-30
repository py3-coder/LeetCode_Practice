class Solution {
    public boolean makeEqual(String[] words) {
        HashMap<Character,Integer> map =new HashMap<>();
        int n=words.length;
        if(n==1){
            return true;
        }
        for(String str :words){
             for(int i=0;i<str.length();i++){
                 map.put(str.charAt(i),map.getOrDefault(str.charAt(i),0)+1);
             }
        }
        
        for(var entry : map.entrySet()){
            if(entry.getValue()%n!=0){
                return false;
            }
        }
        return true;
    }
}