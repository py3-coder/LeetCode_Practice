class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        
        // Lets Try BFS ->
        Set<String> set = new HashSet<>();
        set.add(startGene);
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->(a.t-b.t));
        pq.offer(new Pair(startGene,0));
        
        while(!pq.isEmpty()){
            Pair  pp = pq.peek();
            pq.poll();
            String pgene =pp.n;
            if(pgene.equals(endGene)){
                return  pp.t;
            }
            
            for(String gene : bank){
                if(!set.contains(gene) && diffGeneLen(gene , pgene)==1){
                    set.add(gene);
                    pq.offer(new Pair(gene ,pp.t+1));
                }
            }
        }
        return -1;
        
    }
    public int diffGeneLen(String a,String b){
        int cnt=0;
        for(int i=0;i<8;i++){
            if(a.charAt(i)!=b.charAt(i)){
                cnt++;
            }
        }
        return cnt;
    }
}

class Pair{
    String n;
    int t;
    
    Pair(String _n,int _t){
        this.n =_n;
        this.t =_t;
    }
}