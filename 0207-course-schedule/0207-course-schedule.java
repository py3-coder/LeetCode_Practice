class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
        int cnt=0;
        while(!que.isEmpty()){
            int node=que.poll();
            cnt++;
            
            for(int currNode :adj.get(node)){
                indegree[currNode]--;
                if(indegree[currNode]==0){
                    que.offer(currNode);
                }
            }
        }
        if(cnt==numCourses){
            return true;
        }else{
            return false;
        }
    }
}