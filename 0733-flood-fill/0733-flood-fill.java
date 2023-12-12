class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int mat[][] = image;
        int initC =image[sr][sc];
        int row[] ={0,1,0,-1};
        int col[] ={1,0,-1,0};
        dfs(sr,sc,initC,color,mat,image,row,col);
        return mat;
    }
    public static void dfs(int sr,int sc,int initC,int fc,int[][] mat,int[][] image,int[] row,int[] col){
        mat[sr][sc] =fc;
        
        for(int i=0;i<4;i++){
            int newR =row[i]+sr;
            int newC =col[i]+sc;
            if(newR<mat.length && newR>=0 && newC<mat[0].length && newC>=0 && image[newR][newC]==initC && mat[newR][newC]!=fc){
                dfs(newR,newC,initC,fc,mat,image,row,col);
            }
        }
    }
    
}