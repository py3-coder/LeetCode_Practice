class Solution {
    public int findChampion(int n, int[][] edges) {
        
        //Topo sort type concept
        int[] indegree = new int[n];
        
        for(int[] edge : edges){
            indegree[edge[1]]++;
        }
        int cnt=0,node=-1;
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                cnt++;
                node=i;
            }
        }
        
        return (cnt>1)?-1:node;
        
    }
}