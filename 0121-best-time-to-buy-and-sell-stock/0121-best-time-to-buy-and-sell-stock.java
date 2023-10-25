class Solution {
    public int maxProfit(int[] prices) {   
        // Broute Force 
        int n = prices.length;
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
        
        
        //Lets do it more simple way
        int res=0;
        int ele=100001;
        for(int val :prices){
            ele =Math.min(val,ele);
            if(res<(val-ele)){
                res =val-ele;
            }
        }
        return res;
    }
}