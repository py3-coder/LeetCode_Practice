class Solution {
    public void setZeroes(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    markrow(matrix,n,m,i);
                    markcol(matrix,n,m,j);
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==-100000){
                    matrix[i][j]=0;
                }
            }
        }
    }
    public static void markrow(int[][] matrix,int n,int m,int i){
        for(int j=0;j<m;j++){
            if(matrix[i][j]!=0){
                matrix[i][j]=-100000;
            }
        }
    }
    public static void markcol(int[][] matrix,int n,int m,int j){
        for(int i=0;i<n;i++){
            if(matrix[i][j]!=0){
                matrix[i][j]=-100000;
            }
        }
    }
}