class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        // Approch -1 ::
        // Sorting + Traverse array form back and add happiness
        // TC : O(nlogn) + O(k)
        // SC : O(1)
        
        
        // Heap - 
        // TC - O(nlogk) 
        // SC - O(k)
        
        
        PriorityQueue<Integer> pq  = new PriorityQueue<>((a,b)->(a-b));
        for(int ele : happiness){
            pq.offer(ele);
            while(pq.size()>k){
                pq.poll();
            }
        }
        long ans=0;
        while(k > 0){
            ans += Math.max(pq.poll() - (k-1), 0);
            k--;
        }
        return ans;
    }
}