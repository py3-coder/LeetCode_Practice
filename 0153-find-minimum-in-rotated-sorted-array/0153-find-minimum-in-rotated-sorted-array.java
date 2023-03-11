class Solution {
    public int findMin(int[] arr) {
        int len = arr.length;
        if(len==1){
            return arr[0];
        }
        int start=0;
        int end =len-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            int next =(mid+1)%len;
            int prev = (mid+len-1)%len;
            if(arr[mid]<arr[next] && arr[mid]<arr[prev]){
                return arr[mid];
            }else if(arr[0]<=arr[mid]){
                start = mid+1;
            }else if(arr[len-1]>=arr[mid]){
                end = mid-1;
            }
        }
        return arr[0];
    }
}