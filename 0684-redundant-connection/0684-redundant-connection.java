class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n =edges.length;
        DisjointSet  ds = new DisjointSet(n+1);
        for(int i=0;i<n;i++){
            int u =edges[i][0];
            int v =edges[i][1];
            if(ds.findPar(u)==ds.findPar(v)){
                return new int[]{u,v};
            }else{
                ds.unionBySize(u,v);
            }
        }
        return new int[]{};
    }
}
class DisjointSet{
    List<Integer> size = new ArrayList<>();
    List<Integer> parent  = new ArrayList<>();
    
    DisjointSet(int n){
        for(int i=0;i<=n;i++){
            size.add(1);
            parent.add(i);
        }
    }
    
    public int findPar(int node){
        if(node == parent.get(node)){
            return node;
        }
        int par = findPar(parent.get(node));
        parent.set(node,par);
        return parent.get(node);
    }
    
    public void unionBySize(int u,int v){
        int ulp_u =findPar(u);
        int ulp_v =findPar(v);
        
        if(ulp_u==ulp_v) return ;
        
        if(size.get(ulp_u)>size.get(ulp_v)){
            parent.set(ulp_v,ulp_u);
            size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
        }else{
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v,size.get(ulp_u)+size.get(ulp_v));
        }
    }
}