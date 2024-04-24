class Solution {
    public int makeConnected(int n, int[][] connections) {
         DisjointSet ds =new DisjointSet(n);
        
        int cntExtraEdge=0;
        int cntdissConnected =0;
        
        for(int i=0;i<connections.length;i++){
            int u =connections[i][0];
            int v =connections[i][1];
            
            if(ds.findPar(u) != ds.findPar(v)){
                ds.unionByRank(u,v);
            }else{
                cntExtraEdge++;
            }
        }
        
        for(int i=0;i<n;i++){
            if(ds.findPar(i)==i) cntdissConnected++;
        }
        int res =cntdissConnected-1;
        if(cntExtraEdge>=res){
            return res;
        }
        return -1;
    }
}

class DisjointSet{
    ArrayList<Integer> rank ;
    ArrayList<Integer> parent;
    ArrayList<Integer> size;
    
    
    DisjointSet(int n){
        rank = new ArrayList<>();
        parent = new ArrayList<>();
        size = new ArrayList<>();
        for(int i=0;i<n;i++){
            rank.add(1);
            parent.add(i);
            size.add(1);
        }
    }
    
    
    public int findPar(int node){
        if(parent.get(node) == node){
            return node;
        }
        int par = findPar(parent.get(node));
        //path compression ::
        parent.set(node,par);
        return parent.get(node);
    }
    
    public void unionBySize(int u,int v){
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
    public void unionByRank(int u,int v){
        int utp_u =findPar(u);
        int utp_v =findPar(v);
        
        if(utp_u == utp_v) return;
        
        if(rank.get(utp_u)==rank.get(utp_v)){
            parent.set(utp_v, utp_u);
            rank.set(utp_u , rank.get(utp_u)+1);
        }else if(rank.get(utp_u) >rank.get(utp_v)){
            parent.set(utp_u,utp_v);
        }else if(rank.get(utp_u) < rank.get(utp_v)){
            parent.set(utp_v,utp_u);
        }
    }
}
