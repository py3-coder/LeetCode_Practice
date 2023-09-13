class Solution {
    public String minWindow(String s, String t) {
        //Sliding Window Technique :: 
        int n=s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int count=map.size();
        int res=Integer.MAX_VALUE;
        int start=0,end=0;
        int fend=0,fstart=0;
        
        
        while(end<n){
            char c= s.charAt(end);
            if(map.containsKey(c)){
                map.put(c,map.get(c)-1);
                if(map.get(c)==0){
                    count--;
                }
            }
            if(count>0){
                end++;
            }
            else if(count==0){
                while(count==0){
                    if(res>end-start+1){
                    res=end-start+1;
                    fend=end;
                    fstart=start;
                    //System.out.println(s.substring(fstart,fend+1));
                    }
                    char st =s.charAt(start);
                    if(map.containsKey(st)){
                        map.put(st,map.get(st)+1);
                        if(map.get(st)==1){
                            count++;
                        }
                    }
                    start++;
                }
                end++;
            }
        }
        if(res>s.length())  return "";   
        return s.contains(s.substring(fstart,fend+1))?s.substring(fstart,fend+1):"";
    }
}