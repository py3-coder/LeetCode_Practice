class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int i=0,j=0;
        while(i<str1.length() && j<str2.length()){
            char ch1 =str1.charAt(i),ch2=str2.charAt(j);
            if((ch2-ch1 + 26) % 26 <= 1){
                j++;
            }
            i++;
        }
        return j==str2.length();
    }
}