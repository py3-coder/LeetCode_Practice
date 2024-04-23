class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // Lets try with Dijkestra ::
        
        //1. Lets Make adj ::
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] ed : edges){
            int u = ed[0];
            int v = ed[1];
            int wt = ed[2];
            adj.get(u).add(new ArrayList<>(Arrays.asList(v,wt)));
            adj.get(v).add(new ArrayList<>(Arrays.asList(u,wt)));
            
        }
        int[] cityCnt = new int[n];
        int city =n;
        for(int i=0;i<n;i++){
            cityCnt[i] =dijkestra(i,adj,n,distanceThreshold);
            city = Math.min(city,cityCnt[i]);
        }
        
        List<Integer> test  = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(cityCnt[i]==city){
                test.add(i);
            }
        }
        return test.get(test.size()-1);
        
        
        
        
    }
    public int dijkestra(int src ,ArrayList<ArrayList<ArrayList<Integer>>> adj,int n,int disth){
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->(a.wt-b.wt));
        int[] dist = new int[n];
        Arrays.fill(dist,(int)1e9);
        dist[src]=0;
        pq.offer(new Pair(src,0));
        
        while(!pq.isEmpty()){
            Pair pp = pq.peek();
            pq.poll();
            int node =pp.n;
            
            for(ArrayList<Integer> ad : adj.get(node)){
                int currNode = ad.get(0);
                int currWt =ad.get(1);
                
                if(dist[currNode]>dist[node]+currWt){
                    dist[currNode] =dist[node]+currWt;
                    pq.offer(new Pair(currNode,dist[currNode]));
                }
            }
        }
        int cnt=0;
        for(int i=0;i<n;i++){
            if(dist[i]<=disth){
                cnt++;
            }
        }
        return cnt;
    }
}
class Pair{
    int n;
    int wt;
    
    Pair(int _n,int _wt){
        this.n =_n;
        this.wt=_wt;
    }
}