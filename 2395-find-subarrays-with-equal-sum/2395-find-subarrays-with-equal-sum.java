class Solution {
    public boolean findSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=1;i<nums.length;i++){
            if(set.contains(nums[i]+nums[i-1])){
                return true;
            }
            set.add(nums[i]+nums[i-1]);
        }
       return false;
}
}