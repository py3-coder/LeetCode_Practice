class Solution {
    public int minSteps(String s, String t) {
        HashMap<Character,Integer> map =new HashMap<>();
        int cntOps=0;
        for(char ch : s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(char ch : t.toCharArray()){
            if(map.containsKey(ch) && map.get(ch)>0){
                map.put(ch,map.get(ch)-1);
            }else{
                cntOps++;
            }
        }
        System.out.print(map);
        return Math.abs(cntOps);
    }
}