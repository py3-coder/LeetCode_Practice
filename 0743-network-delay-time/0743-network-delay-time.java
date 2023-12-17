class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Plan BFS ::
         int[] dist = new int[n+1];
         Arrays.fill(dist, Integer.MAX_VALUE);
         List<List<Pair>> adj = new ArrayList<>();
         for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
         for (int[] time: times) {
             adj.get(time[0]).add(new Pair(time[1], time[2]));
         }
         Queue<Pair> q = new LinkedList<>();
         dist[k] = 0;
         q.offer(new Pair(k, 0));
         while (!q.isEmpty()) {
             Pair p = q.poll();
             int node = p.first;
             int time = p.second;
             for (Pair pair: adj.get(node)) {
                 int adjNode = pair.first;
                 int t = pair.second;
                 if (dist[node] + t < dist[adjNode]) {
                     dist[adjNode] = dist[node] + t;
                     q.offer(new Pair(adjNode, dist[adjNode]));
                 }
             }
         }
         int max = 0;
         for (int i = 1; i <= n; i++) {
             if (dist[i] == Integer.MAX_VALUE) return -1;
             max = Math.max(max, dist[i]);
         }
         return max;
        
    }
    public class Pair{
        int first;
        int second;
        Pair(int first,int second){
            this.first = first;
            this.second =second;
        }
    }
}