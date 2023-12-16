class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        //Let's Implement : Djikestra Algo::
        int n=grid.length;
        int m=grid[0].length;
        //edge cases ::
        if(grid[0][0]!=0 || grid[n-1][m-1]!=0) return -1;
        PriorityQueue<Triple> pq =new PriorityQueue<>((a,b)->(a.wt==b.wt)?(b.x-a.x):(a.wt-b.wt));
        pq.offer(new Triple(1,0,0));
        int[][] dist = new int[n][m];
        Arrays.stream(dist).forEach(a -> Arrays.fill(a, (int)1e6));
        
        dist[0][0]=1;
        
        while(!pq.isEmpty()){
            Triple curr =pq.poll();
            int wt=curr.wt;
            int row =curr.x;
            int col =curr.y;
            
            int[] drow ={0,1,1,1,0,-1,-1,-1};
            int[] dcol ={1,1,0,-1,-1,-1,0,1};
            
            for(int i=0;i<8;i++){
                int nrow =row+drow[i];
                int ncol =col+dcol[i];
                
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==0){
                    if(dist[nrow][ncol]>wt+1){
                        dist[nrow][ncol]=wt+1;
                        pq.offer(new Triple(wt+1,nrow,ncol));
                    }
                }
            }
        }
        if(dist[n-1][m-1]==(int)1e6){
            return -1;
        }
        return dist[n-1][m-1];
        
        
    }
    static class Triple{
        int wt;
        int x;
        int y;
        Triple(int _wt,int _x,int _y){
            this.wt =_wt;
            this.x=_x;
            this.y=_y;
        }
    }
                                                    
                                                
                                                    
}