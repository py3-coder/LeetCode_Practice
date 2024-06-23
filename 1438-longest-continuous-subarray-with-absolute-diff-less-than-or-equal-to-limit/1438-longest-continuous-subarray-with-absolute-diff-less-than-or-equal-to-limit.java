class Solution {
    public int longestSubarray(int[] nums, int limit) {
        // Broute Force ::
        // O(n^3)  -- TLE
        //simple 3 loop ( i -- n)
        // j<i --- n
        // find max and min betwn i to j a
        // k = i to j
        // check if they are less or equal to limit 
        // maxlen = max(maxlen , j-i+1)
        
        
        //O(n^2)  --- TLE 
        // i -- n
        // j<i to n
        // find max and min betwn i to j a
        // if(max - min <= limit) 
        // update maxlen
        // else break ;
        
        //Optimised 
        // Sliding window :
        
        // int n = nums.length;
        // int maxlen = 0 ;
        // int start =0,end =0;
        // int max = Integer.MIN_VALUE , min = Integer.MAX_VALUE;
        // while(end < n){
        //     max =Math.max(max, nums[end]);
        //     min =Math.min(min ,nums[end]);
        //     int diff =Math.abs(max-min);
        //     if(diff<=limit){
        //         maxlen = Math.max(maxlen , end - start+1);
        //         end++;
        //     }else{
        //         // reset and start the computation
        //         max = Integer.MIN_VALUE ;
        //         min = Integer.MAX_VALUE;
        //         start++;
        //         end = start;
        //     }
        // }
        // return maxlen;
        
        
        int n = nums.length;
        int maxlen = 1 ;
        int start =0,end =0;
        
        Deque<Integer> maxQ = new LinkedList<>();
        Deque<Integer> minQ = new LinkedList<>();
        while(end < n){
            
            while (!maxQ.isEmpty() && maxQ.peekLast() < nums[end]) {
                maxQ.pollLast();
            } 
            while (!minQ.isEmpty() && minQ.peekLast() > nums[end]) {
                minQ.pollLast();
            }
            maxQ.addLast(nums[end]);
            minQ.addLast(nums[end]);
            
            while (maxQ.peekFirst() - minQ.peekFirst() > limit) {
                if (nums[start] == maxQ.peekFirst()) {
                    maxQ.pollFirst();
                }
                if (nums[start] == minQ.peekFirst()) {
                    minQ.pollFirst();
                }
                ++start;
            }
            maxlen = Math.max(maxlen , end -start+1);
            end++;
        }
        return maxlen;
        
        
        
    }
}