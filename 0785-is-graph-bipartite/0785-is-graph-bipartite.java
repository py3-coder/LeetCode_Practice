class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color,-1);
       
        // Connected Component Check::
        for(int i=0;i<n;i++){
            if(color[i]==-1){
                // if(bfs(i,graph,color)==false){
                //     return false;
                // }
                if(dfs(i,0,graph,color)==false){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean bfs(int i,int[][] graph,int[] col){
        Queue<Pair> que = new LinkedList<>();
        //initial color -0 we have take 0 & 1as color :
        col[i] =0;
        que.offer(new Pair(i,0));
        
        while(!que.isEmpty()){
            Pair pp = que.poll();
            int nodes =pp.v;
            int color =pp.c;
            
            for(int node : graph[nodes]){
                if(col[node]==-1){
                    if(color == 0){
                        col[node]=1;
                        que.offer(new Pair(node,1));
                    }else{
                        col[node]=0;
                        que.offer(new Pair(node,0));
                    }
                }else {
                    if(col[node] == color){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public boolean dfs(int node,int color ,int[][] graph,int[] col){
        col[node] = color;
        
        for(int nodes : graph[node]){
            if(col[nodes]==-1 ){
                if(dfs(nodes,1-color,graph,col)==false){
                    return false;
                }
            }else {
                if(col[nodes] == color){
                    return false;
                }
            }
        }
        return true;
    }
     
}
class Pair{ 
    int v;
    int c;
    Pair(int _v,int _c){
        this.v =_v;
        this.c =_c;
    }
}