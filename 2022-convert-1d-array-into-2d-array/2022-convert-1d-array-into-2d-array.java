class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(m*n!=original.length)  return new int[][]{};
        int[][] arr = new int[m][n];
        for(int i=0;i<original.length;i++){
            arr[i/n][i%n] =original[i];
        }
        return arr;
    }
}