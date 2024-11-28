class Solution {
    public int minimumObstacles(int[][] grid) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        int[][] dir = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int m = grid.length, n = grid[0].length;
        int[][] count = new int[m][n];
        for(int i = 0;i < m;i++) {
            Arrays.fill(count[i], Integer.MAX_VALUE);
        }
        count[0][0] = 0;
        q.offer(new int[]{0, 0, 0});
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int cost = cur[2];
            if(x == m - 1 && y == n - 1) {
                return cost;
            }
            for(int i = 0;i < 4;i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];
                if(nx < 0 || ny < 0 || nx >= m || ny >= n) {
                    continue;
                }
                int now = cur[2];
                if(grid[nx][ny] == 1) {
                    now++;
                }
                if(now >= count[nx][ny]) {
                    continue;
                }
                
                count[nx][ny] = now;
                q.offer(new int[] {nx, ny, now});
            }
        }
        return -1;
    }
}