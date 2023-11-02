class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String s1=strs[0];
        String s2=strs[strs.length-1];
        int indx=0;
        while(indx<s1.length() && indx<s2.length()){
            if(s1.charAt(indx)==s2.charAt(indx)){
                indx++;
            }else{
                break;
            }
        }
        return s1.substring(0,indx);
    }
}