class Solution {
    public int maximumSafenessFactor(List < List < Integer >> grid) {
        int n = grid.size();

        //edge case ::
        if (grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1) {
            return 0;
        }
        // n ~ 400
        // TC : O(n^2) + log(n) * O(n^2)   ~ n^2 * log(n)
        // SC : O(n^2) +2* O(n^2) 
        
        
        int[][] res = bfs(grid);
        // binary search - BS on ans pattern 
        //return bs(res);
        
        
        // Follow Up Question -
        // if  n = 4000 
        // will this work --- a big no 
        // almost it will reach 10*8 and might we see TLE 
        
        
        // So how to solve this --
        
        List<Integer>[] temp = new ArrayList[n*n];
        for(int i=0;i<n*n;i++){
            temp[i] = new ArrayList<>();
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int key = i*n+j;
                temp[res[i][j]].add(key);
            }
        }

        // think of DSU :-
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};

        DisjointSet ds = new DisjointSet(n*n);
        int start=0 , end = n*n-1;
        
        for(int r=temp.length-1;r>=0;r--){
            for(int curr : temp[r]){
                    int  i= curr/n;
                    int  j= curr%n;
                for(int k=0;k<4;k++){
                    int nr = i+dx[k];
                    int nc = j+dy[k];
                    int key  = nr*n+nc;
                    if(isvalid(nr, nc, n) && res[nr][nc]>=r){
                        ds.unionbySize(curr,key);
                    }
                }
            }
            if(ds.findPar(start)==ds.findPar(end)){
                return r;
            }
        }
        return -1;
    }
    public int bs(int[][] res){
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

    // distance matrix --
    public int[][] bfs(List < List < Integer >> grid) {
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
        return res;
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

class DisjointSet{
    List<Integer> parent;
    List<Integer> size;
    
    DisjointSet(int n){
        parent  = new ArrayList<>();
        size = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            parent.add(i);
            size.add(1);
        }
    }
    
    
    public int findPar(int u){
        if(parent.get(u)==u) return u;
        
        int pu  = findPar(parent.get(u));
        parent.set(u,pu);
        return parent.get(u);
    }
    
    public void unionbySize(int u,int v){
        int utp_u = findPar(u);
        int utp_v = findPar(v);
        
        if(utp_u == utp_v) return ;
        if(size.get(utp_u)>size.get(utp_v)){
            parent.set(utp_v, utp_u);
            size.set(utp_u,size.get(utp_u)+size.get(utp_v));
        }else{
            parent.set(utp_v, utp_u);
            size.set(utp_u,size.get(utp_u)+size.get(utp_v));
        }
    }
}