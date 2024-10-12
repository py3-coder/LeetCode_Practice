class Solution {
    public int minGroups(int[][] intervals) {
        // TC : O(nlogn) + O(n) 
        // SC : O(n) 
//         Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
//         PriorityQueue<Integer> pq = new PriorityQueue<>();
        
//         for(int[] interval : intervals){
//             if(!pq.isEmpty() && pq.peek()<interval[0]){
//                 pq.poll();
//             }
//             pq.offer(interval[1]);
//         }
//         return pq.size();
        
        
        // Lets try with Sweep line algo.
        int maxi=-1;
        int[] line = new int[1000005];
        
        for(int[] interval : intervals){
            line[interval[0]]+=1;
            line[interval[1]+1]-=1;
        }
        
        for(int i=1;i<1000005;i++){
            line[i]+=line[i-1];
            maxi = Math.max(maxi , line[i]);
        }
        return maxi;
        
    }
}