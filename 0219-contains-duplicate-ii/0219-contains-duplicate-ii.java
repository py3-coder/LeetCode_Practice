class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            Integer prev_Val = map.put(nums[i],i);
            if(prev_Val!=null && i-prev_Val<=k){
                return true;
            }
        }
        return false;
    }
}