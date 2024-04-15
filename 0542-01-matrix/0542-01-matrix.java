class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        
        int[][] vis =new int[n][m];
        int[][] res =new int[n][m];
        
        Queue<Triple> que = new LinkedList<>();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]== 0 && vis[i][j]!=1){
                    vis[i][j]=1;
                    res[i][j]=0;
                    que.offer(new Triple(i,j,0));
                }
            }
        }
    
        int dx[] ={0,1,0,-1};
        int dy[] ={1,0,-1,0};
        while(!que.isEmpty()){
            Triple tt = que.poll();
            int x = tt.x;
            int y = tt.y;
            int dis =tt.d;
            
            for(int i=0;i<4;i++){
                int nrow = x+dx[i];
                int ncol = y+dy[i];
                
                if(nrow<n && nrow>=0 && ncol<m && ncol>=0 && vis[nrow][ncol]!=1 && mat[nrow][ncol]!=0){
                    res[nrow][ncol] = dis+1;
                    vis[nrow][ncol] =1;
                    que.offer(new Triple(nrow,ncol,dis+1));
                }
            }
        }
    
       return res; 
        
    }
    
}
class Triple{
    int x;
    int y;
    int d;
    
    Triple(int _x,int _y,int _d){
        this.x =_x;
        this.y =_y;
        this.d=_d;
    }
}