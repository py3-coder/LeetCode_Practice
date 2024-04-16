class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        int[] indeg =new int[numCourses];
        for(int i=0;i<numCourses;i++){
            for(int ele:adj.get(i)){
                indeg[ele]++;
            }
        }
        
        
        Queue<Integer> que = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indeg[i]==0){
                que.offer(i);
            }
        }
        int cnt=0;
        while(!que.isEmpty()){
            int nodes  = que.poll();
            cnt++;
            for(int node : adj.get(nodes)){
                indeg[node]--;
                if(indeg[node]==0){
                    que.offer(node);
                }
            }
        }
        if(cnt == numCourses){
            return true;
        }
        return false;
    }
}