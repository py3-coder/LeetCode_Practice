class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
      String sb1 ="";
      String sb2 ="";
        for(String str : word1){
            sb1+=str;
        }
        for(String str : word2){
            sb2+=str;
        }
        return (sb1.equals(sb2))==true?true:false;        
    }
}