class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        int[] vis  =new int[n];
        List<List<Pair>> adj  = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int k=0;
        for(int[] edge : edges ){
            adj.get(edge[0]).add(new Pair(edge[1],succProb[k]));
            adj.get(edge[1]).add(new Pair(edge[0],succProb[k]));
            k++;
        }
        double[] probs = new double[n];
        Queue<Pair> que = new LinkedList<>();
        que.offer(new Pair(start_node , 1.0));
        
        while(!que.isEmpty()){
            Pair pp = que.poll();
            int nod = pp.node;
            double pb = pp.prob;
            
            for(Pair nextNode : adj.get(nod)){
                if(probs[nextNode.node] >= pb*nextNode.prob) continue;
                
                que.offer(new Pair(nextNode.node ,pb*nextNode.prob));
                probs[nextNode.node] =pb*nextNode.prob;
            }
        }
        return probs[end_node];
    }
}

class Pair{
    int node;
    double prob;
    
    Pair(int _node ,double _prob){
        this.node = _node;
        this.prob= _prob;
    }
}