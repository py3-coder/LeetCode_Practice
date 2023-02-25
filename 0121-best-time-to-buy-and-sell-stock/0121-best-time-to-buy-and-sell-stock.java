class Solution {
    public int maxProfit(int[] prices) {
        int curr_max=0;
        int max_so_far=0;
        for(int i=1;i<prices.length;i++){
            curr_max = Math.max(0, curr_max+=prices[i]-prices[i-1]);
            max_so_far=Math.max(curr_max,max_so_far);
        }
        return max_so_far;
    }
}