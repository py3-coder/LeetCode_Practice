class Solution {
    public String destCity(List<List<String>> paths) {
        
        //Lets Do it Using Graph ::
        HashMap<String,Integer> map =new HashMap<>();
        int k=0;
        for(List<String> temp : paths){
            for(String str:temp){
                if(!map.containsKey(str)){
                    map.put(str,k++);
                }
            }
        }
        //System.out.print(map);
        int n =map.size();
        int indegree[] =new int[n];
        List<List<Integer>> adj  = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        //Graph Adj List ::
        for(List<String> temp : paths){
            adj.get(map.get(temp.get(0))).add(map.get(temp.get(1)));
            indegree[map.get(temp.get(1))]++;
        }
        //System.out.println(adj);
        Queue<Integer> que = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                que.offer(i);
            }
        }
        List<Integer> path = new ArrayList<>();
        while(!que.isEmpty()){
            int node =que.poll();
            path.add(node);
            
            for(int currNode :adj.get(node)){
                indegree[currNode]--;
                if(indegree[currNode]==0){
                    que.offer(currNode);
                }
            }
        }
        String ans="";
        for(var entry :map.entrySet()){
            int val =entry.getValue();
            if(val == path.get(path.size()-1)){
                ans =entry.getKey();
            }
        }
        return ans;
    }
    
}