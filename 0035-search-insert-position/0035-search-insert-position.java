class Solution {
    public int searchInsert(int[] A, int target) {
    //  int low = 0, high = A.length-1;
    //     while(low<=high){
    //         int mid = (low+high)/2;
    //         if(A[mid] == target) return mid;
    //         else if(A[mid] > target) high = mid-1;
    //         else low = mid+1;
    //     }
    //     return low;
    return recursiveBinarySearch(A,0,A.length-1,target);
    }
    public static int recursiveBinarySearch(int nums[],int low,int high,int target){
        if(low>high) return low;
        int mid =low+(high-low)/2;
        if(nums[mid]==target) return mid;
        else if(nums[mid]>target){
            return recursiveBinarySearch(nums,low,mid-1,target);
        }else{
            return recursiveBinarySearch(nums,mid+1,high,target);
        }
    }
}