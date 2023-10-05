class Solution {
    public int[] searchRange(int[] nums, int target) {
        int arr[] = new int[2];
        arr[0]=firstPostion(nums,target);
        arr[1]=lastPosition(nums,target);
        return arr;
    }
    public static int firstPostion(int[] nums,int target){
        int ans=-1;
        int low=0,high=nums.length-1;
        while(low<=high){
            int mid =low+(high-low)/2;
            if(nums[mid]==target){
                ans=mid;
                high=mid-1;
            }else if(nums[mid]>target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    public static int lastPosition(int[] nums,int target){
        int ans=-1;
        int low=0,high=nums.length-1;
        while(low<=high){
            int mid =low+(high-low)/2;
            if(nums[mid]==target){
                ans=mid;
                low=mid+1;
            }else if(nums[mid]>target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }

}