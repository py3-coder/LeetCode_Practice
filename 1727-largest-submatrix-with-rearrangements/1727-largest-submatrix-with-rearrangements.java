class Solution {
    public int largestSubmatrix(int[][] matrix) {
        for(int i = 1; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 1){
                    matrix[i][j] = matrix[i - 1][j] + 1;
                }
            }
        }
        
        int count = 0;
        
        for(int i = 0; i < matrix.length; i++){
            Arrays.sort(matrix[i]);                                    
            for(int j = 1; j <= matrix[0].length; j++){
                count = Math.max(count, j * matrix[i][matrix[0].length - j]);       
            }
        }
        
        return count;
    }
}