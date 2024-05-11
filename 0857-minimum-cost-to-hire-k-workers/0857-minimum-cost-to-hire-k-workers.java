class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        // Idea -
        // Sort first on basic of ratio - q[i]/w[i] 
        // max_heap --
        
        List<Integer> workers = new ArrayList<>();
        for (int i = 0; i < quality.length; ++i) workers.add(i);
        Collections.sort(workers, (a, b) -> Double.compare(wage[a]/(double)quality[a],                          wage[b]/(double)quality[b]));
           
        PriorityQueue<Integer> maxh = new PriorityQueue<>((a,b)->(quality[b]-quality[a]));
        int qsum=0;
        Double res = Double.MAX_VALUE; 
        for(int q : workers){
            maxh.offer(q);
            qsum+=quality[q];
            if(maxh.size()>k){
                qsum-=quality[maxh.poll()];
            }
            if(maxh.size()==k){
                res = Math.min(res,qsum*(wage[q]/(double)quality[q]));
            }
        }
        
        return res;
    }
}