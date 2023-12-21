class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjoinSet ds =new DisjoinSet(n);
        HashMap<String,Integer> map =new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String mail =accounts.get(i).get(j);
                if(!map.containsKey(mail)){
                    map.put(mail,i);
                }else{
                    ds.unionbySize(i,map.get(mail));
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
class DisjoinSet{
    List<Integer> rank  = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    List<Integer> parent =new ArrayList<>();
    
    
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
        return parent.get(par);
    }
    
    public void unionbySize(int u,int v){
        int ulp_u =findPar(u);
        int ulp_v =findPar(v);
        
        if(ulp_u == ulp_v) return ;
        
        if(size.get(ulp_u)>size.get(ulp_v)){
            parent.set(ulp_v,ulp_u);
            size.set(ulp_u , size.get(ulp_u)+size.get(ulp_v));
        }else{
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v , size.get(ulp_u)+size.get(ulp_v));
        }
    }
    
    public void unionbyRank(int u,int v){
        int ulp_u =findPar(u);
        int ulp_v =findPar(v);
        
        if(ulp_u == ulp_v) return ;
        
        if(rank.get(ulp_u)>rank.get(ulp_v)){
            parent.set(ulp_v,ulp_u);
        }else if(rank.get(ulp_v)>rank.get(ulp_u)){
             parent.set(ulp_u,ulp_v);
        }else{
            parent.set(ulp_v,ulp_u);
            rank.set(ulp_u,rank.get(ulp_u)+1);
        }
    }
}