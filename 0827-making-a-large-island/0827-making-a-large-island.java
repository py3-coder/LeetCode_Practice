class Solution {
    public int largestIsland(int[][] grid) {
        int n =grid.length;
        DisjoinSet ds =new DisjoinSet(n*n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int[] drow ={0,1,0,-1};
                int[] dcol ={1,0,-1,0};
                if(grid[i][j]==1){
                    for(int k=0;k<4;k++){
                        int nrow =i+drow[k];
                        int ncol =j+dcol[k];
                        if(nrow>=0 && nrow<n && ncol>=0 && ncol<n && grid[nrow][ncol]==1){
                            int nodeID =i*n+j;
                            int adjID =nrow*n+ncol;
                            ds.unionBySize(nodeID,adjID);
                        }
                    }
                }
            }
        }   
        int largestSize= 0;
        int cntZero=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int score =0;
                Set<Integer> set =new HashSet<>();
                if(grid[i][j]==0){
                    cntZero++;
                    int[] drow ={0,1,0,-1};
                    int[] dcol ={1,0,-1,0};
                    
                    for(int k=0;k<4;k++){
                        int nrow =i+drow[k];
                        int ncol =j+dcol[k];
                        if(nrow>=0 && nrow<n && ncol>=0 && ncol<n && grid[nrow][ncol]==1){
                            int adjID =nrow*n+ncol;
                            set.add(ds.findPar(adjID));
                        }
                        
                    }
                }
                for(int ele:set){
                    score+=ds.size.get(ele);
                }
                largestSize = Math.max(largestSize,score+1);
            }
        }
        //Final Check ::
        if(cntZero == 0 ){
            return n*n;
        }
        if(cntZero == n*n){
            return 1;
        }
        for(int i=0;i<n*n;i++){
            if(largestSize<ds.size.get(i)+1){
                return ds.size.get(i)+1;
            }
        }
        return largestSize; 
    }
    
}
class DisjoinSet{
    List<Integer> size = new ArrayList<>();
    List<Integer> parent  = new ArrayList<>();
    
    
    DisjoinSet(int n){
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
        int ulp_u =  findPar(u);
        int ulp_v =findPar(v);
        
        if(ulp_u == ulp_v) return;
        
        if(size.get(ulp_u)>size.get(ulp_v)){
            parent.set(ulp_v,ulp_u);
            size.set(ulp_u , size.get(ulp_u)+size.get(ulp_v));
        }else{
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v,size.get(ulp_u)+size.get(ulp_v));
        }
    }
}