class Solution {
    public int hIndex(int[] citations) {
       int n = citations.length;
       int start = 0;
       int end = n-1;
        while(start<=end){
            int mid = start +(end-start)/2;
            //Case 1: when optimal value is in array;
            if(citations[mid]==n-mid){
                return citations[mid];
            }else if(citations[mid]>(n-mid)){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        // Case 2: when element is not in array
        return n-start;
    }
}