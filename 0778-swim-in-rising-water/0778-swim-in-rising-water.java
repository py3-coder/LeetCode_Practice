class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        if(n==1) return 0;
        DisjointSet ds = new DisjointSet(n*n+1);
        int time=0;
        while(ds.findPar(0)!=ds.findPar(n*n-1)){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    
                    
                    if (grid[i][j] > time)
                            continue;
                    
                    int[] dx={0,1,0,-1};
                    int[] dy={1,0,-1,0};
                    
                    for(int k=0;k<4;k++){
                        int ni =dx[k]+i;
                        int nj =dy[k]+j;
                        
                        
                        if(ni>=0 && ni<n && nj>=0 && nj<n && grid[ni][nj]<=time){
                            ds.unionBySize(i*n+j,ni*n+nj);
                        }
                    }
                    
                }
            }
            time++;
        }
        return time-1;
        
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
