class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        HashMap<Integer,Integer> smap = new HashMap<>();
        int start=0,end=0;
        int maxlen=0;
        while(end<s.length()){
            int val = Math.abs(s.charAt(end)-t.charAt(end));
            smap.put(end,val);
            maxCost -=val;
            while(maxCost<0 && end>=start){
                maxCost+=smap.get(start);
                start++;
            }
            maxlen = Math.max(maxlen,end-start+1);
            end++;
        }
        return maxlen;
    }
}