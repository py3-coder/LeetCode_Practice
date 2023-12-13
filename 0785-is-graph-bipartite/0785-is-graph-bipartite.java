class Solution {
    public boolean isBipartite(int[][] graph) {
        //ArrayList<ArrayList<Integer>> adj = new ArrayList
        int n =graph.length;
        int vis[] =new int[n];
        Arrays.fill(vis,-1);
        int color =0;
        
        for(int i=0;i<n;i++){
            if(vis[i]==-1){
                vis[i]=0;
                if(bfs(i,vis,graph,color)==false){
                    return false;
                }
            }
        }
        return true;
        
    }
    private boolean bfs(int initnode,int[] vis,int[][] graph,int initColor){
        Queue<Pair> que = new LinkedList<>();
        que.offer(new Pair(initnode,initColor));
        
        while(!que.isEmpty()){
            Pair pp = que.poll();
            int node= pp.val;
            int color=pp.col;
            
            for(int val : graph[node]){
                if(vis[val]==-1){
                    if(color==0){
                        vis[val]=1;
                        que.offer(new Pair(val,1));
                    }else{
                        vis[val]=0;
                        que.offer(new Pair(val,0));
                    }
                }else{
                    if(vis[val]==color){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    class Pair{
        int val;
        int col;
        Pair(int _v,int _c){
            this.val =_v;
            this.col =_c;
        }
    }
}