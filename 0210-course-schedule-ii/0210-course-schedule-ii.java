class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Topo Sort :: BFS :: Kahn's Algorithms ::
        
        
        // Can Be Done with DFS too ::
        // DFS topo sort :: -Stack and Vis concept ::;
        // Put ele in stack at end of dfs calls ::
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        int[] indegree =new int[numCourses];
        for(int i=0;i<numCourses;i++){
            for(int ele:adj.get(i)){
                indegree[ele]++;
            }
        }
        
        Queue<Integer> que =new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                que.offer(i);
            }
        }
        List<Integer> res = new ArrayList<>();
        while(!que.isEmpty()){
            int node=que.poll();
            res.add(node);
            
            for(int currNode :adj.get(node)){
                indegree[currNode]--;
                if(indegree[currNode]==0){
                    que.offer(currNode);
                }
            }
        }
        if(res.size()!=numCourses){
            // means false case ::
            return new int[0];
        }
        int k=res.size()-1;
        int[] temp =new int[res.size()];
        for(int ele:res){
            temp[k--]=ele;
        }
        
        return temp;
    }
}