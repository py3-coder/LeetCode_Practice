class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int cnt=0;
        int small=Integer.MAX_VALUE;
        long sum=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]<0){
                    cnt++;
                }
                small = Math.min(Math.abs(matrix[i][j]),small);
                sum+=Math.abs(matrix[i][j]);
            }
        }        
        return (cnt%2==0)?sum : sum-2*small;
    }
}