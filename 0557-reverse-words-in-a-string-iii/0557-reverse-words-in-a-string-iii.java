class Solution {
    public String reverseWords(String s) {
        String str[] =s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<str.length;i++){
            StringBuilder ss = new StringBuilder(str[i]);
            sb.append(ss.reverse().toString()+" ");
        }
        return sb.toString().trim();
    }
}
