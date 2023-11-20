class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        long ans=0;
        int limit_m=-1,limit_p=-1,limit_g=-1;
        for(int i=garbage.length-1; i>=0; i--){
            if(limit_m>-1 && limit_g>-1 && limit_p>-1) break;
            for(char ch:garbage[i].toCharArray()){
                if(ch=='M' && limit_m==-1) limit_m=i;
                if(ch=='P' && limit_p==-1) limit_p=i;
                if(ch=='G' && limit_g==-1) limit_g=i;
            }
        }
        for(int i=0; i<=limit_m; i++){
            HashMap<Character,Integer> map=getCount(garbage[i]); 
            int trcl=(i==0)?0:travel[i-1];
            if(map.containsKey('M')){
                ans+=map.get('M');
            }
            ans+=trcl;
        }
        for(int i=0; i<=limit_p; i++){
            HashMap<Character,Integer> map=getCount(garbage[i]);
            int trcl=(i==0)?0:travel[i-1];
            if(map.containsKey('P')){
                ans+=map.get('P');
            }
            ans+=trcl;
        }
        for(int i=0; i<=limit_g; i++){
            HashMap<Character,Integer> map=getCount(garbage[i]);
            int trcl=(i==0)?0:travel[i-1];
            if(map.containsKey('G')){
                ans+=map.get('G');
            }
            ans+=trcl;
        }
        return (int)ans;
    }
    HashMap<Character,Integer> getCount(String str){
        HashMap<Character,Integer> map=new HashMap<>();
        for(char ch:str.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        return map;
    }
}