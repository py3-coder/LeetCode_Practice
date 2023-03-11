class Solution {
    public int[] searchRange(int[] nums, int target) {
       int firstPos =  firstPostion(nums,target);
       int lastPos = lastPostion(nums,target);
        
        int[] res =new int[2];
        res[0] = firstPos;
        res[1] =lastPos;
        return res;
    }
    public static  int firstPostion(int[] arr , int target){
        int start =0;
        int end =arr.length-1;
        int res =-1;
        while(start<=end){
            int mid = start +(end-start)/2;
            if(target==arr[mid]){
                res = mid;
                end = mid-1;
            }else if(target<arr[mid]){
                end = mid-1;
            }else if(target>arr[mid]){
                start = mid+1;
            }
        }
        return res;
    }
    public static  int lastPostion(int[] arr , int target){
        int start =0;
        int end =arr.length-1;
        int res =-1;
        while(start<=end){
            int mid = start +(end-start)/2;
            if(target==arr[mid]){
                res = mid;
                start= mid+1;
            }else if(target<arr[mid]){
                end = mid-1;
            }else if(target>arr[mid]){
                start = mid+1;
            }
        }
        return res;
    }
}