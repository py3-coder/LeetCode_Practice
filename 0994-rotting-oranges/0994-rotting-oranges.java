class Solution {
    public int orangesRotting(int[][] grid) {
        int n =grid.length;
        int m=grid[0].length;
        int cntFresh=0;
        Queue<List<Integer>> que = new LinkedList<>();
        int[][] vis = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    que.offer(new ArrayList<>(Arrays.asList(i, j, 0)));
                    vis[i][j]=2;
                }
                if(grid[i][j]==1){
                    cntFresh++;
                }
            }
        }
        int cnt=0;
        int time=0;
        int drow[] ={0,1,0,-1};
        int dcol[] ={1,0,-1,0};
        while(!que.isEmpty()){
            List<Integer> temp =que.poll();
            int row =temp.get(0);
            int col =temp.get(1);
            int t =temp.get(2);
            time =Math.max(time,t);
            for(int i=0;i<4;i++){
                int nrow =row+drow[i];
                int ncol =col+dcol[i];
                
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]!=2 && grid[nrow][ncol]==1){
                    que.offer(new ArrayList<>(Arrays.asList(nrow,ncol,t+1)));
                    vis[nrow][ncol]=2;
                    cnt++;
                }
                
            }
            
        }
        if(cntFresh!=cnt) return -1;
        return time;
    }
    
}