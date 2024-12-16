class Solution {
    public double maxAmount(String initCurr, List<List<String>> pairs1, double[] rates1, List<List<String>> pairs2, double[] rates2) {
        // adj list
        HashMap<String , HashMap<String,Double>> adj = new HashMap<>();
        
        for(int i=0;i<pairs1.size();i++){
            String a = pairs1.get(i).get(0);
            String b = pairs1.get(i).get(1);
            double rate = rates1[i];
            
            adj.putIfAbsent(a,new HashMap<>());
            adj.putIfAbsent(b,new HashMap<>());
            
            adj.get(a).put(b ,Math.max(adj.get(a).getOrDefault(b,0.0),rate));
            adj.get(b).put(a ,Math.max(adj.get(b).getOrDefault(a,0.0),1/rate));
            
        }
        //System.out.println(adj);
        
        HashMap<String,Double> state = new HashMap<>();
        
        dfs1(initCurr , "" , 1.0 , adj , state);
        
        System.out.println(state);
        
        adj = new HashMap<>();
        for(int i=0;i<pairs2.size();i++){
            String a = pairs2.get(i).get(0);
            String b = pairs2.get(i).get(1);
            double rate = rates2[i];
            
            adj.putIfAbsent(a,new HashMap<>());
            adj.putIfAbsent(b,new HashMap<>());
            
            adj.get(a).put(b ,Math.max(adj.get(a).getOrDefault(b,0.0),rate));
            adj.get(b).put(a ,Math.max(adj.get(b).getOrDefault(a,0.0),1/rate));
            
        }

        //System.out.println(adj);
        
        double[] res = {1.0};

        for (Map.Entry<String, Double> entry : state.entrySet()) {
            dfs2(entry.getKey(), "", entry.getValue(), adj, initCurr, res);
        }

        return res[0];        
    }
    
    
    public void dfs1(String curr , String prev ,double val , HashMap<String,HashMap<String,Double>> adj ,
                     HashMap<String,Double> state){
        state.put(curr , Math.max(state.getOrDefault(curr , 0.0),val));
        
        for(Map.Entry<String, Double> adjNode : adj.getOrDefault(curr , new HashMap<>()).entrySet()){
            
            String nextCurr  = adjNode.getKey();
            double exRate = adjNode.getValue();
            
            if(!nextCurr.equals(prev)){
                dfs1(nextCurr , curr , val*exRate , adj , state);
            }
        }
    }

    public void dfs2(String curr, String prev, double val ,HashMap<String,HashMap<String,Double>> adj ,
                    String initCurr ,double[] res){
        if(curr.equals(initCurr)){
            res[0] = Math.max(res[0],val);
        }
        for(Map.Entry<String , Double > adjNode : adj.getOrDefault(curr , new HashMap<>()).entrySet()){
            
            String nextCurr = adjNode.getKey();
            double exrate = adjNode.getValue();
            
            if(!nextCurr.equals(prev)){
                dfs2(nextCurr,curr,val*exrate,adj,initCurr,res);
            }
        }
    }
}