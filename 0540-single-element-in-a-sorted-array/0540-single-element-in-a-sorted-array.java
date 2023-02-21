class Solution {
    public int singleNonDuplicate(int[] nums) {
     HashMap<Integer, Integer> map = new HashMap<>();
        for(int a : nums){
            map.put(a,map.getOrDefault(a,0)+1);
        }
        int res=0;
		res = Collections.min(map.values());
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) { 
            if (entry.getValue()==res) {
                return entry.getKey();    
            }
        }
        return 0;
    }
}