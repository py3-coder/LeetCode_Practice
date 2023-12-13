class Solution {
    public int[][] updateMatrix(int[][] mat) {
        //BFS ::
        int n=mat.length;
        int m=mat[0].length;
        int vis[][] = new int[n][m];
        int res[][] = new int[n][m];
        
        Queue<Pair> que = new LinkedList<>();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]!=1 && mat[i][j]==0){
                    vis[i][j]=1;
                    res[i][j]=0;
                    que.offer(new Pair(i,j,0));
                }
            }
        }
        int drow[] ={0,1,0,-1};
        int dcol[] ={1,0,-1,0};
        while(!que.isEmpty()){
            Pair pp =que.poll();
            int row = pp.val1;
            int col =pp.val2;
            int dis =pp.dist;
            
            for(int i=0;i<4;i++){
                int nrow =row+drow[i];
                int ncol =col+dcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]!=1 && mat[nrow][ncol]!=0){
                    res[nrow][ncol] =dis+1;
                    vis[nrow][ncol] =1;
                    que.offer(new Pair(nrow,ncol,dis+1));
                }
            }
        }
        return res;
    }
    class Pair{
        int val1;
        int val2;
        int dist;
        Pair(int _v1,int _v2,int _dis){
            this.val1=_v1;
            this.val2=_v2;
            this.dist=_dis;
        }
    }
}