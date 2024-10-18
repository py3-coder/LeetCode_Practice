class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        List<int[]> build = new ArrayList<>();
        for(int[] b : buildings){
            build.add(new int[]{b[0],-b[2]});
            build.add(new int[]{b[1], b[2]});
        }
        Collections.sort(build,(a,b)->{
           if(a[0]==b[0]){
               return a[1]-b[1];
           } 
            return a[0]-b[0];
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        pq.offer(0);
        int prev=0;
        for(int[] b :build){
            
            if(b[1]<0) pq.offer(-b[1]);
            else pq.remove(b[1]);
            int curr =pq.peek();
            if(prev!=curr){
                result.add(new ArrayList<>(Arrays.asList(b[0],curr)));
                prev = curr;
            }
        }
        return result;
    }
}

