class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int start=0,end=0;
        int maxlen=0;
        while(end<s.length()){
            int val = Math.abs(s.charAt(end)-t.charAt(end));
            maxCost -=val;
            if(maxCost<0 && end>=start){
                maxCost+= Math.abs(s.charAt(start)-t.charAt(start));
                start++;
            }
            maxlen = Math.max(maxlen,end-start+1);
            end++;
        }
        return maxlen;
    }
}