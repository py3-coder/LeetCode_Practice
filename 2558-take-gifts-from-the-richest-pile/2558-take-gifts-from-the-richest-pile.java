class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>((a, b) -> Long.compare(b, a));
        for(int ele : gifts){
             pq.offer((long) ele);
        }
        while(k>0){
            long maxGift = pq.poll(); 
            long sqrt = (long) Math.sqrt(maxGift);
            pq.offer(sqrt);
            k--;
        }
        long sum=0;
        while(!pq.isEmpty()){
            sum+=pq.poll();
        }
        return sum;
        
    }
}