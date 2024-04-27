class Solution {
    public int removeStones(int[][] stones) {
        int n =stones.length;
        int maxRow=0;
        int maxCol=0;
        for (int i = 0; i < n; i++) {
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }
        DisjointSet ds = new DisjointSet(maxRow + maxCol + 1);
        HashMap<Integer, Integer> stoneNodes = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int nodeRow = stones[i][0];
            int nodeCol = stones[i][1] + maxRow + 1;
            ds.unionBySize(nodeRow, nodeCol);
            stoneNodes.put(nodeRow, 1);
            stoneNodes.put(nodeCol, 1);
        }

        int cnt = 0;
        for (int it : stoneNodes.keySet()) {
            if (ds.findPar(it) == it) {
                cnt++;
            }
        }
        return n - cnt;
    }
    
}

class DisjointSet{
    List<Integer> size =new ArrayList<>();
    List<Integer> parent =new ArrayList<>();
    
    DisjointSet(int  n){
        for(int i=0;i<=n;i++){
            size.add(1);
            parent.add(i);
        }
    }
    
    public int findPar(int node){
        if(node == parent.get(node)){
            return node;
        } 
        
        int tempar = findPar(parent.get(node));
        parent.set(node,tempar);
        return parent.get(node);
    }
    
    public void unionBySize(int u ,int v){
        int ulp_u =findPar(u);
        int ulp_v =findPar(v);
        
        if(ulp_u == ulp_v) return; 
        
        if(size.get(ulp_u)>size.get(ulp_v)){
            parent.set(ulp_v,ulp_u);
            size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
        }else{
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v,size.get(ulp_u)+size.get(ulp_v));
        }
    }
}