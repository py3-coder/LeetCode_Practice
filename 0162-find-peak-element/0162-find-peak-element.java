class Solution {
    public int findPeakElement(int[] nums) {
        int n=nums.length;
        if(n==1){
            return 0;
        }
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid =low+(high-low)/2;
            //Handle index 0;
            if(mid==0 && nums[mid]>nums[mid+1]){
                return mid;
            }//Hanlde index n-1;
            if(mid==n-1 && nums[mid]>nums[mid-1]){
                return mid;
            }
            if(nums[mid]>nums[mid+1] && nums[mid]>nums[mid-1]){
                return mid;
            }else if(nums[mid]>nums[mid+1]){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return -1;
    }
}