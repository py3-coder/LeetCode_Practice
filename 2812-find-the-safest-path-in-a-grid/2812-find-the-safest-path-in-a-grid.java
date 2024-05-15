class Solution {
    public int maximumSafenessFactor(List < List < Integer >> grid) {
        int n = grid.size();
        int m = grid.get(0).size();

        //edge case ::
        if (grid.get(0).get(0) == 1 || grid.get(n - 1).get(m - 1) == 1) {
            return 0;
        }

        return bfs(grid);


    }

    public int bfs(List < List < Integer >> grid) {
        int n = grid.size();


        int[][] res = new int[n][n];
        int[][] vis = new int[n][n];

        Queue < Pair > que = new LinkedList < > ();

        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1 && vis[i][j] != 1) {
                    vis[i][j] = 1;
                    que.offer(new Pair(i, j));
                }
            }
        }
        
        
        int dist = 0;
        while (!que.isEmpty()) {

            int size = que.size();
            while (size-- > 0) {
                Pair pp = que.peek();
                que.poll();

                int x = pp.x;
                int y = pp.y;
                //System.out.println(dist);
                res[x][y] = dist;

                for (int i = 0; i < 4; i++) {
                    int nr = dx[i] + x;
                    int nc = dy[i] + y;

                    if (isvalid(nr, nc, n) && vis[nr][nc] != 1) {
                        que.offer(new Pair(nr, nc));
                        vis[nr][nc] = 1;
                    }
                }
            }
            dist+=1;
        }



        // binary search - BS on ans pattern 
        int l = 0;
        int h = (int) 1e9;
        int ans = 0;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (isCheck(mid, res)) {
                ans = mid;
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }

        return ans;
    }
    public boolean isCheck(int t, int[][] res) {
        int n = res.length;


        if (res[0][0] < t) return false;

        int[][] vis = new int[n][n];
        Queue < Pair > que = new LinkedList < > ();
        que.offer(new Pair(0, 0));
        vis[0][0] = 1;


        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};

        while (!que.isEmpty()) {
            Pair pp = que.peek();
            que.poll();

            int x = pp.x;
            int y = pp.y;

            if (x == n - 1 && y ==n - 1) return true;

            for (int i = 0; i < 4; i++) {
                int nr = dx[i] + x;
                int nc = dy[i] + y;

                if (isvalid(nr, nc, n) && vis[nr][nc] != 1) {

                    if (res[nr][nc] < t) continue;
                    vis[nr][nc] = 1;
                    que.offer(new Pair(nr, nc));
                }
            }

        }
        return false;

    }
    public boolean isvalid(int r, int c, int n) {
        return (r >= 0 && r < n && c < n && c >=0);
    }
}
class Pair {
    int x;
    int y;

    Pair(int _x, int _y) {
        this.x = _x;
        this.y = _y;
    }
}