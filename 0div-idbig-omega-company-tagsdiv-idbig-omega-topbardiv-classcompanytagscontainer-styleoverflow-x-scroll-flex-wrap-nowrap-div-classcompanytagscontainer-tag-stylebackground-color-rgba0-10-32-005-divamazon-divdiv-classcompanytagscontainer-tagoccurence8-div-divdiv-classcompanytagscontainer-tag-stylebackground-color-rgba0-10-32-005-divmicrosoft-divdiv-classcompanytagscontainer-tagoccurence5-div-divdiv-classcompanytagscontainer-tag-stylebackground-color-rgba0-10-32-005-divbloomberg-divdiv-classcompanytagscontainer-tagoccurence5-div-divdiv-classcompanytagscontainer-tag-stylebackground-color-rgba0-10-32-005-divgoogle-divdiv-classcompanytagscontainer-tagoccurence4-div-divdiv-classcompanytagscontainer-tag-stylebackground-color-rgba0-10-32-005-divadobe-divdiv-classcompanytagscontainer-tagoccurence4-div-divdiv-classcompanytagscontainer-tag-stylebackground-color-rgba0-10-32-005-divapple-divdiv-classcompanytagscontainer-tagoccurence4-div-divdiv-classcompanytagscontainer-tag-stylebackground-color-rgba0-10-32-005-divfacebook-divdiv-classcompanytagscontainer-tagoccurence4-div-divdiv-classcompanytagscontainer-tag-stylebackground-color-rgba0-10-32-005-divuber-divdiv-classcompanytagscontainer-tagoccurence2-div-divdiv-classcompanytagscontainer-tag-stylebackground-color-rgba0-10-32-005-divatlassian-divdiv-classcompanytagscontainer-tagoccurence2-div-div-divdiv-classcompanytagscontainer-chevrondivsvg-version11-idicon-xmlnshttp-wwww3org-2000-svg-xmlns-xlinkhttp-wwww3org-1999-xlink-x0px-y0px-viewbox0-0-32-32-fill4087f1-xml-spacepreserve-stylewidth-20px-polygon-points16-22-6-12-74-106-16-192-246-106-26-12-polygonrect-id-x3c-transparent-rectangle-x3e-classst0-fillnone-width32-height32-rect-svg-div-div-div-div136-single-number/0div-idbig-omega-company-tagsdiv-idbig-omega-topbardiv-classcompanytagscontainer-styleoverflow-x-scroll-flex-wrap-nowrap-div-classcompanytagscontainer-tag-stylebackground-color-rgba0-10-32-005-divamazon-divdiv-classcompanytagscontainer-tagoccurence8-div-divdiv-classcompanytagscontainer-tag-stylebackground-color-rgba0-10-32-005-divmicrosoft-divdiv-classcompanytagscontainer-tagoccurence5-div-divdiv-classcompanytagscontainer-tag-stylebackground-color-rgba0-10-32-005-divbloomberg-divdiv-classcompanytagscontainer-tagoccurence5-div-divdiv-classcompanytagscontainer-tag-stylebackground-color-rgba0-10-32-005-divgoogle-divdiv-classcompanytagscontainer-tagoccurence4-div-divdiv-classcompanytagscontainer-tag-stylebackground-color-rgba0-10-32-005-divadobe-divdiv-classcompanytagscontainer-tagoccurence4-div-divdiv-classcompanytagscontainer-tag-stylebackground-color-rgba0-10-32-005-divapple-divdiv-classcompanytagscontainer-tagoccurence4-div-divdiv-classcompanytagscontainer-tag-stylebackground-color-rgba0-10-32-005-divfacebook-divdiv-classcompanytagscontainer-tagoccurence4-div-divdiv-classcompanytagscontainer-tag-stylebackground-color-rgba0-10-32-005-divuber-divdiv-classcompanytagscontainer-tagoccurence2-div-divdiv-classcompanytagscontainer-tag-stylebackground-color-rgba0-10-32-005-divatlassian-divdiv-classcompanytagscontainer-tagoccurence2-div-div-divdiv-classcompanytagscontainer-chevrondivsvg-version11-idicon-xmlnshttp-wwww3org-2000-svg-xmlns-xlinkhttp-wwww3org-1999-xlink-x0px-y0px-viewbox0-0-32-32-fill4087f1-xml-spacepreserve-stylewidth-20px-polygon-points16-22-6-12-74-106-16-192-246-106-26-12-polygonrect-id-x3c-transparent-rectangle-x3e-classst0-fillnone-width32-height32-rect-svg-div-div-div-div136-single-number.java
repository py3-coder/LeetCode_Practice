class Solution {
    public int singleNumber(int[] nums) {
        //edge case 
        int n= nums.length;
        if(nums.length==1){
            return nums[0];
        }
        Arrays.sort(nums);
        for(int i=0;i<n-1;i+=2){
            if(nums[i]!=nums[i+1]){
                return nums[i];
            }
        }
        if(nums[n-1]!=nums[n-2]){
            return nums[n-1];
        }
        return 0;
    }
}