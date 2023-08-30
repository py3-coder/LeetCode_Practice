class Solution {
    public int maxProfit(int[] prices) {   
        // Broute Force 
        // int n = prices.length;
        // int profit=Integer.MIN_VALUE;
        // if(n==1){
        //     return 0;
        // }
        // for(int i=0;i<n;i++){
        //     for(int j=i+1;j<n;j++){
        //         profit = Math.max(profit,prices[j]-prices[i]);
        //     }
        // }
        // return (profit!=-1)?profit:0;
        // TLE-AYA 
        
        // Lets Optimise
        int curr_max=0;
        int max_so_far=0;
        for(int i=1;i<prices.length;i++){
            curr_max +=prices[i]-prices[i-1];
            curr_max =Math.max(0,curr_max);
            max_so_far =Math.max(max_so_far,curr_max);
        }
        return max_so_far;
    }
}