class Solution {
    public int buttonWithLongestTime(int[][] events) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[0]==b[0] ? a[1]-b[1] : b[0]-a[0]));
        pq.offer(new int[]{events[0][1] , events[0][0]});
        for(int i=1;i<events.length;i++){
            int diff = events[i][1] -  events[i-1][1];
            pq.offer(new int[]{diff , events[i][0]});
        }
        int[] res = pq.peek();
        return res[1];
    }
}