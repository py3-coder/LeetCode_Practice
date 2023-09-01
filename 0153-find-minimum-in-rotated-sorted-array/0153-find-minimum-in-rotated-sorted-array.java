class Solution {
    public int findMin(int[] arr) {
        int n = arr.length;
        if(n==1){
            return arr[0];
        }
        int left =0;
        int right =n-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            int next = ( mid+1)%n;
            int prev = (mid+n-1)%n;
            if(arr[prev]>arr[mid] && arr[next]>arr[mid]){
                return arr[mid];
            }else if(arr[0]<=arr[mid]){
                left = mid+1;
            }else if(arr[n-1]>=arr[mid]){
                right =mid-1;
            }
        }
        return arr[0];
    }
}