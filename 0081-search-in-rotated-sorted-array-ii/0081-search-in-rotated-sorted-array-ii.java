class Solution {
    public boolean search(int[] nums, int target) {
        return binary_search(nums,target);
    }
    
    public static boolean binary_search(int[] arr,int target){
        int start=0;
        int end = arr.length-1;
        while(start<=end){
            int mid = start +(end- start)/2;
            if(target==arr[mid]){
                return true;
            }
            if(arr[mid]>arr[start]){
                // means left side is sorted and lets check the target in left side..
                if (target < arr[mid] && target >= arr[start]) end = mid;
                else start = mid + 1;
            } else if (arr[mid] < arr[start]) { 
                // right side  [mid..end] is sorted
                // check if target in right half
                if (target > arr[mid] && target < arr[start]) start = mid + 1;
                else end = mid;
            }else {  
                // have no idea about the array, but we can exclude arr[start] 
                start++;
            }
        }
    return false;
    }
}
