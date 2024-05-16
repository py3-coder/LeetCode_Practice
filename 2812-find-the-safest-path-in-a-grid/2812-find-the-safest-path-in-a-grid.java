class Solution {
    private int n;
    private int[] vToSafety;
    private List<Integer>[] safetyToVs;

    private void calculateSafety(List<List<Integer>> grid) {
        n = grid.size();
        vToSafety = new int[n * n];
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            List<Integer> row = grid.get(i);
            for (int j = 0; j < n; ++j) {
                int v = n * i + j;
                if (row.get(j) == 0) {
                    vToSafety[v] = -1;
                } else {
                    q.add(v);
                }
            }
        }
        while (!q.isEmpty()) {
            int v = q.remove();
            if (v - n >= 0     && vToSafety[v - n] == -1) { vToSafety[v - n] = vToSafety[v] + 1; q.add(v - n); }
            if (v + n <  n * n && vToSafety[v + n] == -1) { vToSafety[v + n] = vToSafety[v] + 1; q.add(v + n); }
            if (v % n >  0     && vToSafety[v - 1] == -1) { vToSafety[v - 1] = vToSafety[v] + 1; q.add(v - 1); }
            if (v % n <  n - 1 && vToSafety[v + 1] == -1) { vToSafety[v + 1] = vToSafety[v] + 1; q.add(v + 1); }
        }
        safetyToVs = new List[2 * n];
        for (int safety = 0; safety < 2 * n; ++safety) {
            safetyToVs[safety] = new ArrayList<>();
        }
        for (int v = 0; v < n * n; ++v) {
            safetyToVs[vToSafety[v]].add(v);
        }
    }

    private static class Dsu {
        private int n;
        private int[] p;
        private int[] d;

        public Dsu(int n) {
            this.n = n;
            this.p = new int[n];
            this.d = new int[n];
            for (int i = 0; i < n; ++i) {
                p[i] = i;
            }
        }

        private int get(int i) {
            if (p[i] != i) {
                p[i] = get(p[i]);
            }
            return p[i];
        }

        private void merge(int i, int j) {
            i = get(i);
            j = get(j);
            if (d[i] < d[j]) {
                int t = i; i = j; j = t;
            }
            p[j] = i;
            if (d[i] == d[j]) {
                ++d[i];
            }
        }
    }

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        calculateSafety(grid);
        int from = 0, to = n * n - 1;
        Dsu dsu = new Dsu(n * n);
        for (int safety = 2 * n - 2; safety > 0; --safety) {
            for (int v : safetyToVs[safety]) {
                if (v - n >= 0     && vToSafety[v - n] >= safety) { dsu.merge(v, v - n); }
                if (v + n <  n * n && vToSafety[v + n] >= safety) { dsu.merge(v, v + n); }
                if (v % n >  0     && vToSafety[v - 1] >= safety) { dsu.merge(v, v - 1); }
                if (v % n <  n - 1 && vToSafety[v + 1] >= safety) { dsu.merge(v, v + 1); }
            }
            if (dsu.get(from) == dsu.get(to)) {
                return safety;
            }
        }
        return 0;
    }
}



// class Solution {
//     public int maximumSafenessFactor(List < List < Integer >> grid) {
//         int n = grid.size();

//         //edge case ::
//         if (grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1) {
//             return 0;
//         }
//         // n ~ 400
//         // TC : O(n^2) + log(n) * O(n^2)   ~ n^2 * log(n)
//         // SC : O(n^2) +2* O(n^2) 
        
        
//         int[][] res = bfs(grid);
//         // binary search - BS on ans pattern 
//         //return bs(res);
        
        
//         // Follow Up Question -
//         // if  n = 4000 
//         // will this work --- a big no 
//         // almost it will reach 10*8 and might we see TLE 
        
        
//         // So how to solve this --
        
//         // for(int i=0;i<n;i++){
//         //     for(int j=0;j<n;j++){
//         //         System.out.print(res[i][j]+" ");
//         //     }
//         //     System.out.println();
//         // }
        
//         //
        
        
//         // think of DSU :-
//         int[] dx = {0,1,0,-1};
//         int[] dy = {1,0,-1,0};

//         DisjointSet ds = new DisjointSet(n*n);
//         for(int r=401;r>=0;r--){
            
//             for(int i=0;i<n;i++){
//                 for(int j=0;j<n;j++){
                    
//                     if(res[i][j]>=r){
//                         for(int k=0;k<4;k++){
//                             int nr = i+dx[k];
//                             int nc = j+dy[k];
//                             int pkey =i*n+j;
//                             int key  = nr*n+nc;
//                             if(isvalid(nr, nc, n) && res[nr][nc]>=r && ds.findPar(pkey)!=ds.findPar(key)){
//                                 ds.unionbySize(pkey,key);
//                             }
//                         }
//                     }else{
//                         continue;
//                     }
//                 }
//             }
//             if(ds.findPar(0)==ds.findPar(n*n-1)){
//                 return r;
//             }
//         }
//         return -1;

//     }
//     public int bs(int[][] res){
//         int l = 0;
//         int h = (int) 1e9;
//         int ans = 0;
//         while (l <= h) {
//             int mid = l + (h - l) / 2;
//             if (isCheck(mid, res)) {
//                 ans = mid;
//                 l = mid + 1;
//             } else {
//                 h = mid - 1;
//             }
//         }

//         return ans;
//     }

//     // distance matrix --
//     public int[][] bfs(List < List < Integer >> grid) {
//         int n = grid.size();


//         int[][] res = new int[n][n];
//         int[][] vis = new int[n][n];

//         Queue < Pair > que = new LinkedList < > ();

//         int[] dx = {0,1,0,-1};
//         int[] dy = {1,0,-1,0};

//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < n; j++) {
//                 if (grid.get(i).get(j) == 1 && vis[i][j] != 1) {
//                     vis[i][j] = 1;
//                     que.offer(new Pair(i, j));
//                 }
//             }
//         }
        
        
//         int dist = 0;
//         while (!que.isEmpty()) {

//             int size = que.size();
//             while (size-- > 0) {
//                 Pair pp = que.peek();
//                 que.poll();

//                 int x = pp.x;
//                 int y = pp.y;
//                 //System.out.println(dist);
//                 res[x][y] = dist;

//                 for (int i = 0; i < 4; i++) {
//                     int nr = dx[i] + x;
//                     int nc = dy[i] + y;

//                     if (isvalid(nr, nc, n) && vis[nr][nc] != 1) {
//                         que.offer(new Pair(nr, nc));
//                         vis[nr][nc] = 1;
//                     }
//                 }
//             }
//             dist+=1;
//         }
//         return res;
//     }
//     public boolean isCheck(int t, int[][] res) {
//         int n = res.length;


//         if (res[0][0] < t) return false;

//         int[][] vis = new int[n][n];
//         Queue < Pair > que = new LinkedList < > ();
//         que.offer(new Pair(0, 0));
//         vis[0][0] = 1;


//         int[] dx = {0,1,0,-1};
//         int[] dy = {1,0,-1,0};

//         while (!que.isEmpty()) {
//             Pair pp = que.peek();
//             que.poll();

//             int x = pp.x;
//             int y = pp.y;

//             if (x == n - 1 && y ==n - 1) return true;

//             for (int i = 0; i < 4; i++) {
//                 int nr = dx[i] + x;
//                 int nc = dy[i] + y;

//                 if (isvalid(nr, nc, n) && vis[nr][nc] != 1) {

//                     if (res[nr][nc] < t) continue;
//                     vis[nr][nc] = 1;
//                     que.offer(new Pair(nr, nc));
//                 }
//             }

//         }
//         return false;

//     }
//     public boolean isvalid(int r, int c, int n) {
//         return (r >= 0 && r < n && c < n && c >=0);
//     }
// }
// class Pair {
//     int x;
//     int y;

//     Pair(int _x, int _y) {
//         this.x = _x;
//         this.y = _y;
//     }
// }

// class DisjointSet{
//     List<Integer> parent;
//     List<Integer> size;
    
//     DisjointSet(int n){
//         parent  = new ArrayList<>();
//         size = new ArrayList<>();
        
//         for(int i=0;i<n;i++){
//             parent.add(i);
//             size.add(1);
//         }
//     }
    
    
//     public int findPar(int u){
//         if(parent.get(u)==u) return u;
        
//         int pu  = findPar(parent.get(u));
//         parent.set(u,pu);
//         return parent.get(u);
//     }
    
//     public void unionbySize(int u,int v){
//         int utp_u = findPar(u);
//         int utp_v = findPar(v);
        
//         if(utp_u == utp_v) return ;
//         if(size.get(utp_u)>size.get(utp_v)){
//             parent.set(utp_v, utp_u);
//             size.set(utp_u,size.get(utp_u)+size.get(utp_v));
//         }else{
//             parent.set(utp_v, utp_u);
//             size.set(utp_u,size.get(utp_u)+size.get(utp_v));
//         }
//     }
// }