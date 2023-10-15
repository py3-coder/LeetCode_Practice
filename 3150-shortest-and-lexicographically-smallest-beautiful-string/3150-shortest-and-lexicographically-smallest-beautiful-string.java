class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        List<String> str = new ArrayList<>();
        int start=0;
        int end=0;
        int count=0;
        int min =s.length();
        while(end<s.length()){
            if(s.charAt(end)=='1'){
                count++;
            }
            while(count>k || start<s.length() && s.charAt(start) == '0'){
                if(s.charAt(start)=='1'){
                    count--;
                }
                start++;
            }
            if(count==k){
                int len =end-start+1;
                if(min>len){
                    str.clear();
                    str.add(s.substring(start,end+1));
                    min=len;
                }else if(min==len){
                    str.add(s.substring(start,end+1));
                }
            }
            end++;
        }
        str.sort(Comparator.naturalOrder());
        return str.isEmpty()?"":str.get(0);
    }
}