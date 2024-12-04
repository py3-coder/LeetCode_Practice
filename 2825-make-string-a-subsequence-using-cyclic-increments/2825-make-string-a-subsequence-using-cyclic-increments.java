class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int i=0,j=0;
        while(i<str1.length() && j<str2.length()){
            char ch1 =str1.charAt(i),ch2=str2.charAt(j);
            if( ch1 == ch2  || ch1+1==ch2 || ch1-25==ch2){
                j++;
            }
            i++;
        }
        return j==str2.length();
    }
}