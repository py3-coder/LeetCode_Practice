class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n =rooms.size();
        int[] vis = new int[n];
        dfs(0,vis,rooms);
        
        for(int i=0;i<n;i++){
            if(vis[i]!=1){
                return false;
            }
        }
        return true;
    }
    public void dfs(int node,int[] vis,List<List<Integer>> rooms){
        vis[node]=1;

        for(int currNode : rooms.get(node)){
            if(vis[currNode]!=1){
                dfs(currNode,vis,rooms);
            }
        }
    }
}