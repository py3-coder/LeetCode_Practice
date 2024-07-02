class Solution {
    static int cnt=0;
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        List<List<Integer>> adj = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int restrictNode : restricted){
            set.add(restrictNode);
        }
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int[] vis = new int[n];
        cnt =1;
        vis[0]=1;
        dfs(0 , adj, vis ,set);
        return cnt;
    }
    public void dfs(int adjnode ,List<List<Integer>> adj,int[] vis ,HashSet<Integer> set){
        vis[adjnode]=1;
        for(int node : adj.get(adjnode)){
            if(!set.contains(node) && vis[node]!=1){
                cnt++;
                dfs(node ,adj ,vis,set);
            }
        }
        return ;
    }
}