class Solution {
    public int maxProfit(int[] prices) {
        int lsf = Integer.MAX_VALUE;
        int op =0;
        int pst =0;
        for(int i=0;i<prices.length;i++){
            if(lsf > prices[i]){
                lsf = prices[i];
            }
            pst = prices[i]-lsf;
            if(op<pst){
                op = pst;
            }
        }
        return op;
    }
}