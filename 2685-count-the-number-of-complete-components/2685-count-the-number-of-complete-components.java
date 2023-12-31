class Solution {
    static int nodeCount,edgeCount;
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int[] vis =new int[n];
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        
        int cnt=0;
        for(int i=0;i<n;i++){
            nodeCount = 0;
            edgeCount = 0;
            if(vis[i]!=1){
                dfs(i,vis,adj);
                if(nodeCount*(nodeCount - 1) == edgeCount) cnt += 1;
            }
        }
        return cnt;
    }
    public void dfs(int node,int[] vis,List<List<Integer>> adj){
        vis[node]=1;
        nodeCount++;
        edgeCount+=adj.get(node).size();
        for(int currNode :adj.get(node)){
            if(vis[currNode]!=1){
                dfs(currNode,vis,adj);
            }
        }
    }
}

