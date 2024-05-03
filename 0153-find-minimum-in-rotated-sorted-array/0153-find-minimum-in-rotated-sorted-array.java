class Solution {
    public int findMin(int[] nums) {
        // int n = arr.length;
        // if(n==1){
        //     return arr[0];
        // }
        // int left =0;
        // int right =n-1;
        // while(left<=right){
        //     int mid = left+(right-left)/2;
        //     int next = ( mid+1)%n;
        //     int prev = (mid+n-1)%n;
        //     if(arr[prev]>arr[mid] && arr[next]>arr[mid]){
        //         return arr[mid];
        //     }else if(arr[0]<=arr[mid]){
        //         left = mid+1;
        //     }else if(arr[n-1]>=arr[mid]){
        //         right =mid-1;
        //     }
        // }
        // return arr[0];
        int start =0;
        int end =nums.length-1;
        while(start<end){
            int mid = start +(end-start)/2;
            
            if(nums[mid]>nums[end]){
                //Unsorted side 
                start = mid+1;
            }else if(nums[mid]<nums[end]){
                end = mid;
            }else if(nums[mid]==nums[end]){
                end--;
            }
        }
        return nums[start];
    }
}