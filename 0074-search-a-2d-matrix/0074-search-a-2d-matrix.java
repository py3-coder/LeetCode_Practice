class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Lets Apply for Binary Search 
        int n=matrix.length;
        int m=matrix[0].length;
        int left=0;
        int right=m*n-1;
        while(left<=right){
            int mid =left+(right-left)/2;
            if(matrix[mid/m][mid%m]==target){
                return true;
            }
            if(matrix[mid/m][mid%m]<target){
                left =mid+1;
            }else{
                right=mid-1;
            }
        }
        return false;   
    }
}