class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int v = graph.length;
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<v;i++){
            for(int j=0;j<graph[i].length;j++){
                adj.get(i).add(graph[i][j]);
            }
        }
        //System.out.println(adj);
        int[] vis = new int[v];
        int[] pathvis = new int[v];
        int[] check = new int[v];
        
        for(int i=0;i<v;i++){
            if(vis[i]!=1){
                dfs(i,vis,pathvis,check,adj);
            }
        }
        
        List<Integer> safe = new ArrayList<>();
        for(int i=0;i<v;i++){
            if(check[i]==1){
                safe.add(i);
            }
        }
        return safe;
    }
    public static boolean dfs(int node,int[] vis,int[] pathvis,int[] check,ArrayList<ArrayList<Integer>> adj){
        vis[node]=1;
        pathvis[node]=1;
        check[node]=0;
        
        for(int ele : adj.get(node)){
            if(vis[ele]!=1 && pathvis[ele]!=1){
                if(dfs(ele,vis,pathvis,check,adj)==true){
                    return true;
                }
            }
            else if(pathvis[ele]==1){
                return true;
            }
        }
        pathvis[node]=0;
        check[node]=1;
        return false;
    }
}