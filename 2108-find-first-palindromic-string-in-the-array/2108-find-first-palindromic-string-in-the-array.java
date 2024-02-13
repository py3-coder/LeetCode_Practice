class Solution {
    public String firstPalindrome(String[] words) {
        for(int i=0;i<words.length;i++){
        if(isp(words[i]))
        return words[i];
        }
        return "";
        
    }
    public boolean isp(String s)
    {
        StringBuffer sb=new StringBuffer(s);
        sb=sb.reverse();
        return s.equals(""+sb);
    }
}