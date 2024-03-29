class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        int[]  vis =new int[n];
        // dfs(source,vis,adj);
        // if(vis[destination]!=1){
        //     return false;
        // }
        // return true;
        
        //BFS ::
        vis[source]=1;
        Queue<Integer> que = new LinkedList<>();
        que.offer(source);
        while(!que.isEmpty()){
            int currNode =que.poll();
            if(currNode==destination) return true;
            for(int adjNode : adj.get(currNode)){
                if(vis[adjNode]!=1){
                    vis[adjNode]=1;
                    que.offer(adjNode);
                }
            }
        }
        return false;
        
    }
    public void dfs(int node,int[] vis ,List<List<Integer>> adj){
        vis[node]=1;
        for(int currNode : adj.get(node)){
            if(vis[currNode]!=1){
                dfs(currNode,vis,adj);
            }
        }
    }
    
}