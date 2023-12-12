class Solution {
    public int maxProduct(int[] nums) {
        //1. Approch : nlogn 
        //2. Heap : nlog2
        PriorityQueue<Integer> min = new PriorityQueue<>();
        for(int ele:nums){
            min.offer(ele);
            while(min.size()>2){
                min.poll();
            }
        }
        int v1 =min.poll()-1;
        int v2 =min.poll()-1;
        return v1*v2;
    }
}