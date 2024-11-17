class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int ans = Integer.MAX_VALUE;
        long Csum=0;
        
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(
                (a, b) -> Long.compare(a.sum, b.sum)
        );

        for(int i=0;i<nums.length;i++){
            Csum += nums[i];
             
            if(Csum>=k){
                ans = Math.min(ans , i+1);
            }
            while(!pq.isEmpty() && Csum-pq.peek().sum >=k){
                Pair pp = pq.poll();
                ans = Math.min(ans , i-pp.indx);
            }
            
            pq.offer(new Pair(Csum , i));
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
        
    }
    public class Pair{
        long sum ;
        int indx;
        
        Pair(long _sum,int _indx){
            this.sum =_sum;
            this.indx= _indx;
        }
    }
}