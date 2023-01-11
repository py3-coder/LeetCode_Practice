class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        //create adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
         adj.add(new ArrayList<>());   
        }
        //populate the adjacency list
        for(int [] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        //call the function
        return minTimeToCollectApples(0,adj,hasApple,0);
    }
    //
    int minTimeToCollectApples(int indx ,List<List<Integer>> adj, List<Boolean> hasApple ,int parent){
        //variables to keep track
        int total =0;
        //for each neighbour of current
        for(int nbr : adj.get(indx)){
        // if the neighbor is the parent node, then we skip
        if (nbr == parent)
        continue;
        // we recursively call the helper function for each neighbor
        total += minTimeToCollectApples(nbr, adj, hasApple, indx);
        }
        // If current node is not the root (0th) node, and it has an apple or any of           // its descendant has then we need to add 2 time for moving to and from it
        if( indx != 0 && (hasApple.get(indx) || total > 0))
          total += 2;
        return total;
    }
}