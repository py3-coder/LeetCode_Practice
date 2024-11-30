class Solution {
    public int[][] validArrangement(int[][] pairs) {
        Map<Integer,Integer> indeg = new HashMap<>();
        Map<Integer,Integer> outdeg = new HashMap<>();
        Map<Integer , Stack<Integer>> adj = new HashMap<>();
        int start = pairs[0][0];
        
        for(int[] p : pairs ){
            adj.computeIfAbsent(p[0], v -> new Stack<>()).push(p[1]);
            indeg.put(p[1],indeg.getOrDefault(p[1],0)+1);
            outdeg.put(p[0],outdeg.getOrDefault(p[0],0)+1);
        }
        
        //to get staring node:-
        for (int[] p : pairs) {
            if (indeg.getOrDefault(p[0], 0) - outdeg.getOrDefault(p[0], 0) == -1) {
                start = p[0];
                break;
            }
        }
        List<int[]> path = new ArrayList<>();
        dfs(start , adj , path);
        int[][] ans = new int[path.size()][2];
        int cnt = 0;
        for (int i = path.size() - 1; i >= 0; i--){
            ans[cnt] = new int[]{path.get(i)[1], path.get(i)[0]};
            cnt++;
        }
        return ans;
    }
    public void dfs(int start ,Map<Integer , Stack<Integer>> adj , List<int[]> path ){
        Stack<Integer> st = adj.getOrDefault(start, new Stack<>());
        while (!st.isEmpty()) {
            int adjnode = st.pop();
            dfs(adjnode, adj, path);
            path.add(new int[]{adjnode, start});
        }
    }
}