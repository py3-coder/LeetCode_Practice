class Solution {
    public int strStr(String haystack, String needle) {
     if(haystack.length() < needle.length()){
         return -1;
     }
     if(haystack.indexOf(needle.charAt(0))>=0){
         return haystack.indexOf(needle);
     }else{
         return -1;
     }   
    }
}