class Solution {
    public int findCenter(int[][] edges) {
        int n =edges.length+1;
        int[] conn =new int[n+1];
        
        for(int i=0;i<edges.length;i++){
            conn[edges[i][0]]++;
            conn[edges[i][1]]++;
        }
        int node=0,maxi=0;
        for(int i=0;i<=n;i++){
            if(maxi<conn[i]){
                maxi =conn[i];
                node =i;
            }
        }
        return node;
    }
}