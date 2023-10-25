class Solution {
    //static int[][][] memo = new int[1001][2][101];
    static HashMap<String,Integer> map = new HashMap<>();
    public int maxProfit(int k, int[] prices) {
        //1. Recursion::
        //return solveRec(prices,0,0,k);

        // 2. Memoization::
        // 3 chnaging parameter:) Use either 3dp or hashmap:)
        //return solveMemo(prices,0,0,k);

        return solveTab(prices,k);

        //return solveTabSpaceOptmised(prices);
    }
    public static int solveRec(int[] prices,int indx,int buy,int cnt){
        if(indx==prices.length) return 0;
        if(cnt<0) return 0;
        
        int profit=0;
        if(buy==0){
            // buy::
            profit =-prices[indx]+solveRec(prices,indx+1,1,cnt-1);
        }else{
            //sell::
            profit =prices[indx]+solveRec(prices,indx+1,0,cnt);
        }
        int skip =solveRec(prices,indx+1,buy,cnt);
        
        return Math.max(skip,profit);
    }
    public static int solveMemo(int[] prices,int indx,int buy,int cnt){
        if(indx==prices.length) return 0;
        if(cnt<0) return 0;

        String str =indx+"-"+buy+"-"+cnt;
        if(map.containsKey(str)){
            return map.get(str);
        }
        int profit=0;
        if(buy==0){
            // buy::
            profit =-prices[indx]+solveMemo(prices,indx+1,1,cnt-1);
        }else{
            //sell::
            profit =prices[indx]+solveMemo(prices,indx+1,0,cnt);
        }
        int skip =solveMemo(prices,indx+1,buy,cnt);
        map.put(str,Math.max(skip,profit));
        return Math.max(skip,profit);
    }
    public static int solveTab(int[] prices,int k){
        //Tabulation::)
        int n=prices.length;
        int tab[][][] = new int[n+1][2][k+1];

        for(int ind=n-1;ind>=0;ind--){
            for(int buy=0;buy<=1;buy++){
                for(int cap=1;cap<=k;cap++){
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
        return  tab[0][0][k];
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