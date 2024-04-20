class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        
        for(int i=0;i<n+1;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edges : times){
            int u = edges[0];
            int v = edges[1];
            int cost =edges[2];
            
            adj.get(u).add(new ArrayList<>(Arrays.asList(v,cost)));
        }
        int[] dist = new int[n+1];
        Arrays.fill(dist,(int)1e6);
        dist[k] =0;
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->(a.time-b.time));
        
        pq.offer(new Pair(k,0));
        
        while(!pq.isEmpty()){
            Pair pp = pq.peek();
            pq.poll();
            
            int currNode = pp.node;
            int timetake =pp.time;
            
            for(ArrayList<Integer> list : adj.get(currNode)){
                if(dist[list.get(0)] > timetake +list.get(1)){
                    dist[list.get(0)]= timetake +list.get(1);
                    
                    pq.offer(new Pair(list.get(0),dist[list.get(0)]));
                }
            }
        }
        int mini =0;
        for(int i=1;i<=n;i++){
            if(dist[i]==(int)1e6){
                return -1;
            }
            mini = Math.max(dist[i],mini);
        }
        return  mini;
    }
    
    
}
class Pair{
    int node;
    int time;
    
    Pair(int _n,int _t){
        this.node =_n;
        this.time =_t;
    }
}