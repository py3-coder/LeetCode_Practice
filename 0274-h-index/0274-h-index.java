class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        return h_indexII(citations);
        
    }
    public int h_indexII(int arr[]){
        int n = arr.length;
        int start =0;
        int end =arr.length-1;
        while(start<=end){
            int mid = start +(end-start)/2;
            //Case 1:
            if(arr[mid]==n-mid){
                return arr[mid];
            }else if(arr[mid]>(n-mid)){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        //Case 2:
        return n-start;
    }
}