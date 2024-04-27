class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int  n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                if(!map.containsKey(accounts.get(i).get(j))){
                    map.put(accounts.get(i).get(j),i);
                }else{
                    ds.unionBySize(i,map.get(accounts.get(i).get(j)));
                }
            }
        }
        
        List<List<String>> res =new ArrayList<>();
        for(int i=0;i<n;i++){
            res.add(new ArrayList<>());
        }
        
        for(var entry :map.entrySet()){
            int val =entry.getValue();
            int ulp =ds.findPar(val);
            res.get(ds.findPar(val)).add(entry.getKey());
        }
        List<List<String>> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(res.get(i).size()==0){
               continue;
            }
            Collections.sort(res.get(i));
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(int p=0;p<res.get(i).size();p++){
                temp.add(res.get(i).get(p));
            }
            ans.add(temp);
            
        }        
        return ans;
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
