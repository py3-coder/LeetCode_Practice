class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Algo 
        for(int arr[]:matrix){
            if(binarysearch(arr,target)==true){
                return true;
            }
        }
        return false;
    }
    
    public boolean binarysearch(int[] arr , int target){
        int start=0;
        int end =arr.length-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(arr[mid]==target){
                return true;
            }if(arr[mid]<target){
                start=mid+1;
            }else{
                end =mid-1;
            }
        }
        return false;
    }
}