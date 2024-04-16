class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] indeg = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] ed : prerequisites){
            adj.get(ed[0]).add(ed[1]);
            indeg[ed[1]]++;
        }
        List<Integer> lis = new ArrayList<>();
        Queue<Integer> que = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indeg[i]==0){
                que.offer(i);
            }
        }
        
        while(!que.isEmpty()){
            int nod = que.poll();
            lis.add(nod);
            for(int ele : adj.get(nod)){
                indeg[ele]--;
                if(indeg[ele]==0){
                    que.offer(ele);
                }
            }
        }
        if(lis.size()!=numCourses){
            // means false case ::
            return new int[0];
        }
        int k=lis.size()-1;
        int[] temp =new int[lis.size()];
        for(int ele:lis){
            temp[k--]=ele;
        }
        
        return temp;
    }
}