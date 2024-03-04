class Solution {
    public int minSwapsCouples(int[] row) {
        if (row == null || row.length < 2) return 0;

        int number = 0;
        DisjointSet disjointSets = new DisjointSet(row.length/2);
        for (int i = 0; i<row.length; i = i+2){
            if (!isCouple(row[i], row[i+1])){
                if (disjointSets.UnionBySize(row[i]/2, row[i+1]/2)){
                    number++;
                }
            }
        }
        
        return number;
    }

    private boolean isCouple(int i, int j) {
        return (Math.min(i, j) & 1) == 0 && Math.abs(i - j) == 1;
    }
}

class DisjointSet{
    List<Integer> size = new ArrayList<>();
    List<Integer> parent  = new ArrayList<>();
    
    public DisjointSet(int n){
        for(int i=0;i<n;i++){
            size.add(1);
            parent.add(i);
        }
    }
    
    public int findPar(int u){
        if(parent.get(u) == u){
            return u;
        }
        int up = findPar(parent.get(u));
        parent.set(u ,up);
        return parent.get(u);
    }
    
    public boolean UnionBySize(int u,int v){
        int ulp_u = findPar(u);
        int ulp_v =findPar(v);
        
        if(ulp_u == ulp_v) return false;
            
        if(size.get(ulp_u)>size.get(ulp_v)){
            parent.set(ulp_v,ulp_u);
            size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
        }else{
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v,size.get(ulp_u)+size.get(ulp_v));
        }
        return true;
    }
}