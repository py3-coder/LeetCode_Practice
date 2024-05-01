class Solution {
    static int timer=1;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>> adj  = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(List<Integer> edge : connections){
            adj.get(edge.get(0)).add(edge.get(1));
            adj.get(edge.get(1)).add(edge.get(0));
        }
        
        int[] time = new int[n];
        int[] vis = new int[n];
        int[] low = new int[n];
        
        List<List<Integer>> bridge = new ArrayList<>();
        dfs(0,-1,adj,time,vis,low,bridge);
        
        return bridge;
    } 
    public  void dfs(int node,int par,ArrayList<ArrayList<Integer>> adj,int[] time,int[] vis,int[] low,List<List<Integer>> bridge){
        vis[node]=1;
        time[node] = low[node] =timer;
        timer++;
        
        
        for(int ele : adj.get(node)){
            if(ele == par) continue;
            
            if(vis[ele]!=1){
                dfs(ele,node,adj,time,vis,low,bridge);
                low[node] = Math.min(low[node],low[ele]);
                
                if(low[ele]> time[node]){
                    bridge.add(Arrays.asList(node,ele));
                }
            }else{
                low[node] = Math.min(low[node],low[ele]);
            }
        }
    }
}