class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m =image[0].length;
        
        int[][] vis = new int[n][m];
        Arrays.stream(vis).forEach(a -> Arrays.fill(a,-1));
        
        dfs(sr,sc,color,vis,image);
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]!=color){
                    vis[i][j] = image[i][j];
                }
            }
        }
        return vis;
        
        
    }
    public void dfs(int row,int col,int c,int[][] vis,int[][] image){
        vis[row][col]=c;
        
        int[] dx ={0,1,0,-1};
        int[] dy ={1,0,-1,0};
        
        for(int i=0;i<4;i++){
            int nrow =row+dx[i];
            int ncol =col+dy[i];
            
            if(nrow<image.length && ncol<image[0].length && nrow>=0 && ncol>=0 && image[nrow][ncol]== image[row][col] && vis[nrow][ncol]!=c){
                dfs(nrow,ncol,c,vis,image);
            }
        }
    }
}