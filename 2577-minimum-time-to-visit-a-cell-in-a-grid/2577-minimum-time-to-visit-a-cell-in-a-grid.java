class Solution {
    public int minimumTime(int[][] grid) {
        int n = grid.length , m = grid[0].length;
        if (grid[0][1] > 1 && grid[1][0] > 1) return -1;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        int[][] vis = new int[n][m];
        int[] dx = {1,0,-1,0};
        int[] dy = {0,-1,0,1};
        
        pq.offer(new int[]{0,0,grid[0][0]});
        int ans = Integer.MAX_VALUE;
        
        while(!pq.isEmpty()){
            int[] temp  = pq.poll();
            int row = temp[0], col = temp[1] , time = temp[2];
            //System.out.println(row+" "+col+" "+time);
            if(row == n-1 && col == m-1){
                ans = Math.min(ans , time);
                return ans;
            }
            if (vis[row][col] == 1) continue;
            vis[row][col] = 1;
            for(int i=0;i<4;i++){
                int nr = row+dx[i] , nc = col+dy[i];
                
                if (nr >= 0 && nc >= 0 && nr < n && nc < m && vis[nr][nc] != 1) {
                    int wait = (grid[nr][nc] - time) % 2 == 0 ? 1 : 0;
                    pq.offer(new int[]{nr, nc, Math.max(time + 1, grid[nr][nc] + wait)});
                }
            }
        }
        return -1;
    }
}