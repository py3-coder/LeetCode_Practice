class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edges : flights){
            int u = edges[0];
            int v = edges[1];
            int cost =edges[2];
            
            adj.get(u).add(new ArrayList<>(Arrays.asList(v,cost)));
        }
        int[] dist = new int[n];
        Arrays.fill(dist,(int)1e6);
        dist[src] =0;
        
        PriorityQueue<Triple> pq = new PriorityQueue<>((a,b)->(a.stop==b.stop)?(a.cost-b.cost):(a.stop-b.stop));
       
        pq.offer(new Triple(src,0,0));
        
        while(!pq.isEmpty()){
            Triple tp = pq.peek();
            pq.poll();
            
            int currNode = tp.node;
            int currCost =tp.cost;
            int currStop =tp.stop;
            
            if( currStop>k ){
                continue;
            }
            
            for(ArrayList<Integer> list :adj.get(currNode)){
                int newNode =list.get(0);
                int costtoReach =list.get(1);
                if(dist[newNode]> currCost+costtoReach && currStop<=k){
                    dist[newNode] =currCost+costtoReach;
                    pq.offer(new Triple(newNode ,dist[newNode] ,currStop+1));
                }
            }
        }
        if(dist[dst]==(int)1e6){
            return -1;
        }
        return dist[dst];
    }
    public class Triple{
        int node;
        int cost;
        int stop;
        
        Triple(int _n,int _c,int _s){
            this.node =_n;
            this.cost =_c;
            this.stop =_s;
        }
    }
}