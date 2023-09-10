class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean flag=false;
        for(int[] arr :matrix){
            flag =binarySearch(arr,target);
            if(flag==true){
                return true;
            }
        }
        return flag;
    }
    public static boolean binarySearch(int[] arr,int target){
        int low=0;
        int high=arr.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==target){
                return true;
            }else if(target<arr[mid]){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return false;
    }
}
