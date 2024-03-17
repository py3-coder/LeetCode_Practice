class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1 && i!=j){
                   adj.get(i).add(j);
                   adj.get(j).add(i);
                }
            }
        }
        
        int cnt=0;
        Queue<Integer> que = new LinkedList<>();
        Set<Integer> vis = new HashSet<>();
        
        for(int i=0;i<n;i++){
            if(!vis.contains(i)){
                que.offer(i);
                cnt++;
            }
            while(!que.isEmpty()){
                int node = que.poll();
                
                for(int nod : adj.get(node)){
                    if(!vis.contains(nod)){
                        vis.add(nod);
                        que.offer(nod);
                    }
                }
            }
        }
        
        return cnt;
    }
}