class Solution {
    public int orangesRotting(int[][] grid) {
        
        //adjacency list ::
        Queue<List<Integer>> que = new LinkedList<>();
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    que.offer(new ArrayList<>(Arrays.asList(i, j, 0)));
                }
            }
        }
        
        int[] dy ={0,1,-1,0};
        int[] dx ={1,0,0,-1};
        
        int mintime =0;
        while(!que.isEmpty()){
            List<Integer> list = que.poll();
            int x =list.get(0);
            int y =list.get(1);
            int time = list.get(2);
            mintime = Math.max(time , mintime);
            for(int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];
                if(nx>=0 && ny>=0 && nx<grid.length && ny<grid[0].length && grid[nx][ny]==1){
                    grid[nx][ny]=-1;
                    que.offer(new ArrayList<>(Arrays.asList(nx, ny, time+1)));
                }
            }
        }
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return mintime;
    }
}