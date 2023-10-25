class Solution {
    public int maxProfit(int[] prices) {
        //1. Recursion::
        //return solveRec(prices,0,0,0);

        //2. Memoization::
        // 3 chnaging parameter:) Use either 3dp or hashmap:)
        // HashMap<String,Integer> map =new HashMap<>();
        // return solveMemo(prices,0,0,0,map);

        return solveTab(prices);
        
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
    public static int solveMemo(int[] prices,int indx,int buy,int cnt,HashMap<String,Integer> map){
        if(indx==prices.length) return 0;
        if(cnt>2) return 0;

        String key = indx+"-"+buy+"-"+cnt;
        if(map.containsKey(key)){
            return map.get(key);
        }
        int profit=0;
        if(buy==0){
            // buy::
            profit =-prices[indx]+solveMemo(prices,indx+1,1,cnt+1,map);
        }else{
            //sell::
            profit =prices[indx]+solveMemo(prices,indx+1,0,cnt,map);
        }
        int skip =solveMemo(prices,indx+1,buy,cnt,map);
        map.put(key,Math.max(skip,profit));
        return Math.max(skip,profit);
    }
    public static int solveTab(int[] prices){
        //Tabulation::)
        int n=prices.length;
        int tab[][][] = new int[n+1][2][3];

        for(int ind=n-1;ind>=0;ind--){
            for(int buy=0;buy<=1;buy++){
                for(int cap=1;cap<=2;cap++){
                     if (buy == 0) { // We can buy the stock
                        tab[ind][buy][cap] = Math.max(0 + tab[ind + 1][0][cap],
                                -prices[ind] + tab[ind + 1][1][cap]);
                    }

                    if (buy == 1) { // We can sell the stock
                        tab[ind][buy][cap] = Math.max(0 + tab[ind + 1][1][cap],
                                prices[ind] + tab[ind + 1][0][cap - 1]);
                    }
                }
            }
        }
        return  tab[0][0][2];
    }
}