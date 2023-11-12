class Solution {
    public int maximumStrongPairXor(int[] nums) {
        int result=0;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(Math.abs(nums[i]-nums[j])<=Math.min(nums[i],nums[j])){
                    int xor=nums[i]^nums[j];
                    result =Math.max(result,xor);
                }
            }
        }
        return result;
    }
}