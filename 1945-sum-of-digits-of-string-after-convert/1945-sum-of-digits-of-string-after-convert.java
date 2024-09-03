class Solution {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            int i = ch-96;
            sb.append(i);
        }
       while(k>0){
           int val =0; 
           for(int i=0;i<sb.length();i++){
               char ch = sb.charAt(i);
               val += ch-'0';
           }
           sb.delete(0,sb.length());
           sb.append(val);
           k--;
       }
       return Integer.parseInt(sb.toString());
    }
}