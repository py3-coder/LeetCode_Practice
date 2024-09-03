class Solution {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            int i = ch-96;
            sb.append(i);
        }
       while(k>0){
           int val =0;
           String ss =sb.toString(); 
           for(char ch : ss.toCharArray()){
               val += ch-'0';
           }
           sb = new StringBuilder();
           sb.append(val);
           k--;
       }
       return Integer.parseInt(sb.toString());
    }
}