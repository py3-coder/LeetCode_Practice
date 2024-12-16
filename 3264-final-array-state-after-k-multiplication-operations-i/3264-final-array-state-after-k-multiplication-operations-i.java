class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        // PQ 
        // TC : O(nlogn+klogn)
        // SC :O(n)
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]));
        for(int i=0;i<nums.length;i++){
            pq.offer(new int[]{nums[i],i});
        }
        while(k-->0){
            int[] pp = pq.poll();
            pp[0]*=multiplier;
            pq.offer(pp);
        }
        int[] res = new int[nums.length];
        while(!pq.isEmpty()){
            int[] pair = pq.poll();
            res[pair[1]] = pair[0];
        }
        return res;
    }
}