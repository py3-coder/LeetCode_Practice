class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int start = 0;
        int end =n-1;
        while(start<end){
            int mid = start +(end- start)/2;
            int next = (mid+1)%n;
            if(arr[mid]<arr[next]){
                /// next is greater means the maxi must be in right side;
                start = mid+1;
            }else if(arr[mid]>arr[next]){
                // next is lesser means might the mid or any one in left side should be greater
                end= mid;
            }
        }
        return start;
    }
}