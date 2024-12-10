class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //
        int n = nums.length;
        if(k==1){
            return nums;
        }
        if(n==1){
            return new int[]{0};
        }
        
        int[] res = new int[n-k+1];
        Deque<Integer> que = new ArrayDeque<>();
        int start=0,end=0,pos=0;
        
        while(end<n){
            while(que.size()>0 && que.getLast()<nums[end]){
                que.removeLast();
            }
            que.offer(nums[end]);
            if(end-start+1 == k ){
                res[pos++] = que.getFirst();
                
                if(nums[start] == que.getFirst()){
                    que.removeFirst();
                }
                start++;
            }
            end++;
        }
        return res;
    }
}