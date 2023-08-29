class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int val:nums){
            mp.put(val,mp.getOrDefault(val,0)+1);
        }
        for(int value:mp.keySet()){
            if(mp.get(value)==1){
                 return value;
            }   
        }
    return 0;
    }
}