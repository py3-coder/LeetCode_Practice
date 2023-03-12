class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int start = 0;
        int end =n-1;
        while(start<=end){
            int mid = start +(end- start)/2;
            int next = (mid+1)%n;
            int prev = (mid+n-1)%n;
            if(arr[mid]>arr[next] && arr[mid]>arr[prev]){
                return mid;
            }else if(arr[mid]<arr[prev]){
                end= mid-1;
            }else if(arr[mid]<arr[next]){
                start= mid+1;
            }
        }
        return 1;
    }
}