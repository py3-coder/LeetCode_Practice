class Solution {
    public int orangesRotting(int[][] grid) {
        int n  = grid.length;
        int m =  grid[0].length;
        
        int[][] vis = new int[n+1][m+1];
        int max =0;
        Queue<Triple> que = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    que.offer(new Triple(i,j,0));
                    vis[i][j]=1;  
                }
            }
        }
        max =bfs(que,vis,grid);
        //check ::
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && vis[i][j]!=1){
                    return -1;
                }
            }
        }
        return  max;
        
    }
    public int bfs(Queue<Triple> que,int[][] vis,int[][] grid){
        int[] dx ={0,1,0,-1};
        int[] dy ={1,0,-1,0};
        int maxi =0;
        while(!que.isEmpty()){
            Triple tt = que.poll();
            int x =tt.x;
            int y =tt.y;
            int time =tt.time;
            maxi =Math.max(time,maxi);
            for(int i=0;i<4;i++){
                int new_x = x+dx[i];
                int new_y =y+dy[i];
                
                if(new_x<grid.length && new_x>=0 && new_y<grid[0].length && new_y>=0 && grid[new_x][new_y]==1 &&vis[new_x][new_y]!=1){
                    que.offer(new Triple(new_x,new_y,time+1));
                    vis[new_x][new_y]=1;
                }
            }
        }
        return maxi;
    }
    
    
}
class Triple{
    int x;
    int y;
    int time;
    Triple(int _x,int _y,int _time){
        this.x=_x;
        this.y=_y;
        this.time =_time;
    }
}