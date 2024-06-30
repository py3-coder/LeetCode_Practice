class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        Arrays.sort(edges , (a,b)->(b[0]-a[0]));
        DisjointSet alice = new DisjointSet(n);
        DisjointSet bob = new DisjointSet(n);
        int cnt =0;
        for(int[] edge : edges){
             int u = edge[1];
             int v = edge[2];
            if(edge[0] ==3){ 
                if(alice.findPar(u) == alice.findPar(v) && bob.findPar(u) == bob.findPar(v)){
                    cnt++;
                }else{
                    alice.unionBySize(u,v);
                    bob.unionBySize(u,v);
                } 
            }else if(edge[0]==2){
                if(bob.findPar(u) == bob.findPar(v)){
                    cnt++;
                }else{
                    bob.unionBySize(u,v);
                }
            }else{
                if(alice.findPar(u) == alice.findPar(v)){
                    cnt++;
                }else{
                    alice.unionBySize(u,v);
                }
            }
        }
        int counter = Collections.max(alice.size) + Collections.max(bob.size);
        if(counter != 2*(n)){
            return -1;
        }
        return cnt;
        
    }
}

class DisjointSet{
    ArrayList<Integer> parent = new ArrayList<>();
    ArrayList<Integer> size = new ArrayList<>();
    
    public DisjointSet(int n){
        for(int i=0;i<=n;i++){
            parent.add(i);
            size.add(1);
        }
    }
    
    public int findPar(int node){
        if(parent.get(node) == node){
            return node;
        }
        
        int par = findPar(parent.get(node));
        parent.set(node , par);
        return parent.get(node) ;
    }
    
    
    public void unionBySize(int u , int v){
        int utp_u = findPar(u);
        int utp_v = findPar(v);
        
        if(utp_u == utp_v){
            return  ;
        }
        
        if(size.get(utp_u)>size.get(utp_v)){
            parent.set(utp_v,utp_u);
            size.set(utp_u,size.get(utp_u)+size.get(utp_v));
        }else{
            parent.set(utp_u,utp_v);
            size.set(utp_v,size.get(utp_u)+size.get(utp_v));
        }
    }
}