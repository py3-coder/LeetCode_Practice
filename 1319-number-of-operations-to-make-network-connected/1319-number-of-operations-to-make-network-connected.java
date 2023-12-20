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
    List<Integer> size = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent =new ArrayList<>();
    
    public DisjointSet(int n){
        for(int i=0;i<=n;i++){
            rank.add(0);
            size.add(1);
            parent.add(i);
        }
    }
    
    public int findPar(int node){
        if(parent.get(node)==node){
            return node;
        }
        int par =findPar(parent.get(node));
        parent.set(node,par);
        return parent.get(par);
    }
    public void unionByRank(int u,int v){
        int ulp_u =findPar(u);
        int ulp_v =findPar(v);
        
        if(ulp_u == ulp_v) return ;
        
        if(rank.get(ulp_u)>rank.get(ulp_v)){
            parent.set(ulp_v,ulp_u);
        }else if(rank.get(ulp_u)<rank.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
        }else{
            parent.set(ulp_v,ulp_u);
            rank.set(ulp_u,rank.get(ulp_u)+1);
        }
    }
    
    public void unionBySize(int u,int v){
        int ulp_u =findPar(u);
        int ulp_v =findPar(v);
        
        if(ulp_u == ulp_v) return ; 
        
        if(size.get(ulp_u)>size.get(ulp_v)){
            parent.set(ulp_v,ulp_u);
            size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
        }else{
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v,size.get(ulp_u)+size.get(ulp_v));
        }
    }
}
