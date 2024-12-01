class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length , m = moveTime[0].length;
        int[][] dist=new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0]=0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0,0,0});
        
        int[] dx ={0,-1,0,1};
        int[] dy ={1,0,-1,0};
        while(!pq.isEmpty()){
            int[] curr= pq.poll();
            int r = curr[1], c = curr[2] , t=curr[0];
            
            if(t>dist[r][c]) continue;
            
            if(r == n-1 && c == m-1) return t;
            
            for(int i=0;i<4;i++){
                int nr = r+dx[i] , nc = c+dy[i];
                
                if(nr>=0 && nr<n && nc>=0 && nc<m ){
                    int time =Math.max(moveTime[nr][nc],t)+1;
                    
                    if(time<dist[nr][nc]){
                         dist[nr][nc] = time;
                         pq.offer(new int[]{time , nr , nc });
                    }
                   
                }
            }
            
        }
        return -1;
    }
    
}