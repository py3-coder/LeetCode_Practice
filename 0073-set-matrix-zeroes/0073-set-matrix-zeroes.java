class Solution {
    public void setZeroes(int[][] matrix) {
        ArrayList<Pair<Integer, Integer> > lis = new ArrayList<Pair<Integer, Integer>>();
        int i=0,j=0;
        for(i=0;i<matrix.length;i++){
            for(j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    lis.add(new Pair<Integer, Integer>(i, j));
                }
            }
        }
       // System.out.println(lis);
        for (Pair pp:lis) {
            int row= ((Integer) pp.getKey()).intValue();
            int col = ((Integer) pp.getValue()).intValue();
            for(int l=0;l<matrix.length;l++){
                    matrix[l][col]=0;
            }
            for(int m=0;m<matrix[0].length;m++){
                matrix[row][m]=0;
            }
        }
    }
} 