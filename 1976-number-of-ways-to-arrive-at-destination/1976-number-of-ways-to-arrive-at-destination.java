class Solution {
    public int countPaths(int n, int[][] roads) {
        // Lets Make Graph ::
        int MOD =(int)1e9+7;
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<roads.length;i++){
            adj.get(roads[i][0]).add(new Pair((long) roads[i][2],roads[i][1]));
            adj.get(roads[i][1]).add(new Pair((long) roads[i][2],roads[i][0]));
        }
        long[] distance = new long[n];
        int[] ways = new int[n];
        for(int i=0;i<n;i++){
            distance[i] = Long.MAX_VALUE / 2;
            ways[i] = 0;
        }
        distance[0] = 0;
        ways[0] = 1;
        
        PriorityQueue<Pair> pq =new PriorityQueue<>((a,b)->(Long.compare(a.dist,b.dist)));
        
        pq.offer(new Pair(0,0));
        
        while(pq.size() != 0){
            Pair top =pq.poll();
            int node= top.node;
            long dis=  top.dist;
            
            for(Pair curr:adj.get(node)){
                int currNode = curr.node;
               // System.out.println(currNode);
                long currDist =curr.dist;
                if(distance[currNode]>currDist+dis){
                    distance[currNode]=currDist+dis;
                    ways[currNode]=ways[node];
                    pq.offer(new Pair(currDist+dis,currNode));
                }else if(distance[currNode]==currDist+dis){
                    ways[currNode]=(ways[currNode]+ways[node])%MOD;
                }
            }
        }
        return ways[n-1]%MOD;
    }
    class Pair{
        int node;
        long dist;
        Pair(long _dist,int _node){
            this.dist =_dist;
            this.node =_node;
        }
    }
}