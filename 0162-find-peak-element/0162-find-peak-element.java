class Solution {
    public int findPeakElement(int[] nums) {
     int  n = nums.length;
     //Base Case if length==1
     if(n==1){
         return 0;
     }
     int start = 0;
     int end = n-1;
     while(start<=end){
         int mid = start +(end-start)/2;
         if(mid>0 && mid<n-1){
             if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]){
                 return mid;
             }else if(nums[mid]<nums[mid+1]){
                 start = mid+1;
             }else{
                 end = mid-1;
             }
         }
         else if(mid==0){
             if(nums[0]>nums[1]){
                 return 0;
             }else {
                 return 1;
             }
         }
         else if(mid==n-1){
             if(nums[n-1] > nums[n-2]){
                 return n-1;
             }else{
                 return n-2;
             }
         }
     }
     return 0;
    }
}