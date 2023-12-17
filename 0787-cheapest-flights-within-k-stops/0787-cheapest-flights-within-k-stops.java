class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // BFS Dijkstra  Algo :: Modified :::
        
        // Let's Make  Graph ::)
        List<List<Pair>> adj =new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<flights.length;i++){
            int[] temp =flights[i];
            adj.get(temp[0]).add(new Pair(temp[1],temp[2]));
        }
        int dist[] =new int[n];
        Arrays.fill(dist,(int)1e9);
        dist[src]=0;
        PriorityQueue<Triple> pq =new PriorityQueue<>((a,b)->(a.stop-b.stop));
        pq.offer(new Triple(0,src,0));
        
        while(!pq.isEmpty()){
            int step = pq.peek().stop;
            int node =pq.peek().node;
            int dcost =pq.peek().dist;
            pq.poll();
            if(step > k) continue;;
            
            for(Pair curr : adj.get(node)){
                int currNode =curr.node;
                int cost =curr.cost;
                
                if(dcost+cost<dist[currNode] && step<=k){
                    dist[currNode]=dcost+cost;
                    pq.offer(new Triple(step+1,currNode,dcost+cost));
                }   
            }
        }
        if(dist[dst]==(int)1e9){
            return -1;
        }
        return dist[dst];
    }
    static public class Triple{
        int stop;
        int node;
        int dist;
        Triple(int _stop,int _node,int _dist){
            this.stop =_stop;
            this.node=_node;
            this.dist=_dist;
        }
    }
    public class Pair{
        int node;
        int cost;
        Pair(int _node,int _cost){
            this.node =_node;
            this.cost =_cost;
        }
    }
}
