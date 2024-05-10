class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        // TC ~ O(n^2logn)
        // SC ~ O(n)
        
        
        // TC ~ O(max(n,k)logn)
        // SC ~ O(n)
        
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(arr[a[0]]*arr[b[1]]-arr[a[1]]*arr[b[0]]));
        for(int i=0;i<arr.length-1;i++){
            pq.offer(new int[]{i,arr.length-1});
        }
        
        for(int i=0;i<k-1;i++){
            int[] curr = pq.poll();
            
            int numindex = curr[0];
            int denoindex =curr[1];
            
            if(denoindex-1>numindex){
                pq.offer(new int[]{numindex,denoindex-1});
            }
         }
        
       int[] result = pq.poll();
       return new int[] { arr[result[0]], arr[result[1]] };
    }
}