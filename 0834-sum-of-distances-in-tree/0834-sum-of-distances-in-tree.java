class Solution {
    int[] res, count;
    ArrayList<Set<Integer>> adj;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        //Lets try Dijkestra ::-
        
        res = new int[n];
        count = new int[n];
        adj = new ArrayList<>();
        
        Arrays.fill(count,1);
        for(int i=0;i<n;i++){
            adj.add(new HashSet<>());
        }
        for(int[] ed : edges){
            adj.get(ed[0]).add(ed[1]);
            adj.get(ed[1]).add(ed[0]);
        }
        dfs(0,-1);
        dfs2(0,-1,n);
        
        return res;
    }
     private void dfs(int node, int parent) {
        for (int child : adj.get(node)) {
            if (child != parent) {
                dfs(child, node);
                count[node] += count[child];
                res[node] += res[child] + count[child];
            }
        }
    }
    private void dfs2(int node, int parent,int n) {
        for (int child : adj.get(node)) {
            if (child != parent) {
                res[child] = res[node] - count[child] + n - count[child];
                dfs2(child, node,n);
            }
        }
    }
}
