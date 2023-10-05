class Solution {
    public int search(int[] nums, int target) {
        // //Iterative
        // int n = nums.length;
        // int start =0;
        // int end = n-1;
        // while(start<=end){
        //     int mid = start +(end-start)/2;
        //     if(nums[mid]==target){
        //         return mid;
        //     }else if(target<nums[mid]){
        //         end = mid-1;
        //     }else{
        //         start=mid+1;
        //     }
        // }
        // return -1;

        //Recusive Binary Search ::
        return binarysearch(nums,0,nums.length-1,target);
    }
    public static int binarysearch(int[] nums,int low,int high,int target){
        if(low>high){
            return -1;
        }
        int mid  =low+(high-low)/2;
        if(nums[mid]==target){
            return mid;
        }else if(nums[mid]>target){
            return binarysearch(nums,low,mid-1,target);
        }else{
            return binarysearch(nums,mid+1,high,target);
        }
    }
}