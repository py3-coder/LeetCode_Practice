class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        // int res[][] = new int[n][n];
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //        res[j][n-i-1]=matrix[i][j]; 
        //     }
        // }
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         matrix[i][j] =res[i][j];
        //     }
        // }
        
        //Optimal Approch ::
        //Transpose 
        //Rotate 
        
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int temp =0;
                temp =matrix[i][j];
                matrix[i][j] =matrix[j][i];
                matrix[j][i] =temp;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                int temp=0;
                temp =matrix[i][j];
                matrix[i][j] =matrix[i][n-1-j];
                matrix[i][n-1-j]=temp;
            }
        }
    }
}