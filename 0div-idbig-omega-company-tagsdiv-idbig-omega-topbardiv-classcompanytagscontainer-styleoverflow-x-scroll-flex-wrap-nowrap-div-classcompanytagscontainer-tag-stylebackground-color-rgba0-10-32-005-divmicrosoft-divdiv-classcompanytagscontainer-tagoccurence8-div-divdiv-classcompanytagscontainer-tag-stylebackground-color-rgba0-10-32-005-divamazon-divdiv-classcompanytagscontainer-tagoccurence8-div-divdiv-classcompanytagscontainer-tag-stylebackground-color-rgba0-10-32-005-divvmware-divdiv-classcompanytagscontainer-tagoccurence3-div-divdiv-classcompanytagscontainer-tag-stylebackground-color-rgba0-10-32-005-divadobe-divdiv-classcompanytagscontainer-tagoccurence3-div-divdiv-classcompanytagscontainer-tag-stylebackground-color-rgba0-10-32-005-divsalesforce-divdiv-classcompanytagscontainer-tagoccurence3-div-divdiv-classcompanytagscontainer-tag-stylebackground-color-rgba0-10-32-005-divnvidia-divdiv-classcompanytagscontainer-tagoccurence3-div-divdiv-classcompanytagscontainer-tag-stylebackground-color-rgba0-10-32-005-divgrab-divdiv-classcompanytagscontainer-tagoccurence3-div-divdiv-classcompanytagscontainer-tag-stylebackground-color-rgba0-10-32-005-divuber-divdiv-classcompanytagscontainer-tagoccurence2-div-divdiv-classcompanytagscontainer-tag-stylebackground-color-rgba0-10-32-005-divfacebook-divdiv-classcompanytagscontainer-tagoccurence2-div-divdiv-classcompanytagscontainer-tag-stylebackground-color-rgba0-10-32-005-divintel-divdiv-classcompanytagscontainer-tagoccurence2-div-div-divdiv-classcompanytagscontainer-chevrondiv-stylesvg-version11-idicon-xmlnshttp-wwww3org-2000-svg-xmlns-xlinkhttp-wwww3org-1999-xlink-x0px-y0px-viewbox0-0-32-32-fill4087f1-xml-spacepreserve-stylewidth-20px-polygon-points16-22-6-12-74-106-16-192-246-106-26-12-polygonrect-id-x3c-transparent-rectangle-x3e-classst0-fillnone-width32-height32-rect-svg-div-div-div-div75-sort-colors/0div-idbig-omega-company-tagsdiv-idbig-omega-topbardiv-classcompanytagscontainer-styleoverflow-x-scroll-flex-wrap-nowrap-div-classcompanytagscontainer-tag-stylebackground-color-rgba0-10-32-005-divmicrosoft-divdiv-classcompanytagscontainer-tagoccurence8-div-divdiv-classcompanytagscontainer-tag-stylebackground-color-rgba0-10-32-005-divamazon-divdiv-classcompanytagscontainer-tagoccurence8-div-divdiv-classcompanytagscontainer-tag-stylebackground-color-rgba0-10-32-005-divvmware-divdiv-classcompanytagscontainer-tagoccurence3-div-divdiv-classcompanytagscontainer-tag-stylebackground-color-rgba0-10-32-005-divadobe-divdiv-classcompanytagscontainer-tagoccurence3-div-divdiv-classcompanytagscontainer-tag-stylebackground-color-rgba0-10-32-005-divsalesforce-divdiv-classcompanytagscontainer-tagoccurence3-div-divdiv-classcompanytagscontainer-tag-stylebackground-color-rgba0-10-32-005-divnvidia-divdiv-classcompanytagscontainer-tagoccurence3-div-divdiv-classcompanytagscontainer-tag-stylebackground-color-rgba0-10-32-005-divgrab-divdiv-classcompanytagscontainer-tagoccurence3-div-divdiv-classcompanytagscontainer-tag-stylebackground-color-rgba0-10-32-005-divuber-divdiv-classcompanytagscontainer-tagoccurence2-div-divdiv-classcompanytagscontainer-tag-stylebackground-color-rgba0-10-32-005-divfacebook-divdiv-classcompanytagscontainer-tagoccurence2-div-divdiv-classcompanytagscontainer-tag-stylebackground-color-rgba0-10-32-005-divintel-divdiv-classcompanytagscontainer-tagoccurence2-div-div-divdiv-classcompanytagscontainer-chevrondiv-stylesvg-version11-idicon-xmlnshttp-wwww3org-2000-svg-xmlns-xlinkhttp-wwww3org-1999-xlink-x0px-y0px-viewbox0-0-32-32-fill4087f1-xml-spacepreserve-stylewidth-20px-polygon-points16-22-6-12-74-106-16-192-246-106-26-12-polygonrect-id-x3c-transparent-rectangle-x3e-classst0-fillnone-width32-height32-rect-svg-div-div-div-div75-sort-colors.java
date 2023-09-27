class Solution {
    public void sortColors(int[] nums) {
         int low =0,mid=0, high=nums.length-1;
        while(mid<=high){
            if(nums[mid]==0){
                int temp =nums[low];
                nums[low] =nums[mid];
                nums[mid] =temp;
                mid++;
                low++;
            }
            else if(nums[mid]==1){
                mid++;
            }else{
                int temp =nums[high];
                nums[high] =nums[mid];
                nums[mid] =temp;
                //mid++;
                high--;
            }
        }
    }
}