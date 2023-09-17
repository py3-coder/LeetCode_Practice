class Solution {
    public int removeDuplicates(int[] nums) {
        int count=1;
        int k=1;
        int val=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                count++;
                nums[k++]=nums[i];
            }
        }
        return count;
    }
}