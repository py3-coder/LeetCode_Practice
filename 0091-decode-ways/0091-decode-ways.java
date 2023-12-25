class Solution {
    public int numDecodings(String s) {
        HashMap<Integer,Integer> map =new HashMap<>();
        if(s.charAt(0)=='0') return 0;
        return way(s,0,map);
        
    }
    public static int way(String s ,int indx,HashMap<Integer,Integer> map){
        if(indx>s.length()) return 0;
        if(indx==s.length()) return 1;
        if(s.charAt(indx)=='0') return 0;
        if(indx==s.length()-1) return 1;
        
        if(map.containsKey(indx)){
            return map.get(indx);
        }
        if(Integer.valueOf(s.substring(indx,indx+2))<=26){
            int waycnt =way(s,indx+1,map)+way(s,indx+2,map);
            map.put(indx,waycnt);
            return waycnt;
               
        }else{
            int waycnt =way(s,indx+1,map);
            map.put(indx,waycnt);
            return waycnt;
        }
        
    }
    
}