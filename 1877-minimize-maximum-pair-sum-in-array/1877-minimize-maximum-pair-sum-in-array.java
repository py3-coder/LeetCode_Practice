class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int maxi=0;
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            maxi =Math.max(nums[left]+nums[right],maxi);
            left++;
            right--;
        }
        return maxi;
    }
}