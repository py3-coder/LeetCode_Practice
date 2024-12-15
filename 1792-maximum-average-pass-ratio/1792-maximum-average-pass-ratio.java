class Solution {
    public double maxAverageRatio(int[][] classes, int k) {
        double res=0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> {
            double xDiff = (double)(x[0]+1)/(x[1]+1) - (double)x[0]/x[1];
            double yDiff = (double)(y[0]+1)/(y[1]+1) - (double)y[0]/y[1];
        return xDiff > yDiff? -1 : 1;
        });
        
        for(int[] c : classes){
            pq.offer(c);
        }
        while(k-->0){
            int[] c = pq.poll();
            c[0]++;
            c[1]++;
            pq.add(c);
        }
        
        while(!pq.isEmpty()){
            int[] c = pq.poll();
            res += (double)c[0]/c[1];
        }
        return res/classes.length;
    }
}