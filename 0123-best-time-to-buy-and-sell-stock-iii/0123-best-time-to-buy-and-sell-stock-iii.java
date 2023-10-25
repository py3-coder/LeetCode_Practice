class Solution {
    public int maxProfit(int[] prices) {
        //1. Recursion::
        //return solveRec(prices,0,0,0);

        //2. Memoization::
        // 3 chnaging parameter:) Use either 3dp or hashmap:)
        // HashMap<String,Integer> map =new HashMap<>();
        // return solveMemo(prices,0,0,0,map);

        //return solveTab(prices);

        return solveTabSpaceOptmised(prices);
        
    }
    public static int solveRec(int[] prices,int indx,int buy,int cnt){
        if(indx==prices.length) return 0;
        if(cnt>2) return 0;

        int profit=0;
        if(buy==0){
            // buy::
            profit =-prices[indx]+solveRec(prices,indx+1,1,cnt+1);
        }else{
            //sell::
            profit =prices[indx]+solveRec(prices,indx+1,0,cnt);
        }
        int skip =solveRec(prices,indx+1,buy,cnt);
        return Math.max(skip,profit);
    }
    public static int solveTab(int[] prices){
        //Tabulation::)
        int n=prices.length;
        int tab[][][] = new int[n+1][2][3];

        for(int ind=n-1;ind>=0;ind--){
            for(int buy=0;buy<=1;buy++){
                for(int cap=1;cap<=2;cap++){
                     if (buy == 0) {
                        tab[ind][buy][cap] = Math.max(0 + tab[ind + 1][0][cap],
                                -prices[ind] + tab[ind + 1][1][cap]);
                    }
                    if (buy == 1) { 
                        tab[ind][buy][cap] = Math.max(0 + tab[ind + 1][1][cap],
                                prices[ind] + tab[ind + 1][0][cap - 1]);
                    }
                }
            }
        }
        return  tab[0][0][2];
    }
    public static int solveTabSpaceOptmised(int[] prices){
        //Sapce Optimied:: Tabulation::)
        int n=prices.length;
        
        int ahead[][] = new int[2][3];
        int curr[][] = new int[2][3];

        for(int ind=n-1;ind>=0;ind--){
            for(int buy=0;buy<=1;buy++){
                for(int cap=1;cap<=2;cap++){
                     if (buy == 0) {
                        curr[buy][cap] = Math.max(0 + ahead[0][cap],
                                -prices[ind] + ahead[1][cap]);
                    }
                    if (buy == 1) { 
                        curr[buy][cap] = Math.max(0 + ahead[1][cap],
                                prices[ind] + ahead[0][cap - 1]);
                    }
                }
            }
            for (int i = 0; i < 2; i++) {
                for (int j = 1; j < 3; j++) {
                    ahead[i][j] = curr[i][j];
                }
            }
        }
        
        return  ahead[0][2];
    }
}