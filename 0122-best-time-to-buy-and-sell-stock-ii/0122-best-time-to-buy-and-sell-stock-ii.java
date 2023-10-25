class Solution {
    static int memo[][] =new int[30001][2];
    public int maxProfit(int[] prices) {
        //Recursion::)
        //return solveRec(prices,0,1);

        // Arrays.stream(memo).forEach(a->Arrays.fill(a,-1));
        // return solveMemo(prices,0,1);

        return solveTab(prices);
        
    }
    public static int solveRec(int[] prices ,int indx,int buy){
        //Base Case ::
        if(indx==prices.length) return 0;
        int profit=0;
        if(buy==1){
            profit = -prices[indx]+solveRec(prices,indx+1,0);
        }else{
            profit =prices[indx]+solveRec(prices,indx+1,1);
        }
        int skip =solveRec(prices,indx+1,buy);
        return Math.max(profit,skip);
    }
    public static int solveMemo(int[] prices,int indx,int buy){
        //Base Case ::
        if(indx==prices.length) return 0;
        if(memo[indx][buy]!=-1){
            return memo[indx][buy];
        }
        int profit=0;
        if(buy==1){
            profit = -prices[indx]+solveMemo(prices,indx+1,0);
        }else{
            profit =prices[indx]+solveMemo(prices,indx+1,1);
        }
        int skip =solveMemo(prices,indx+1,buy);
        return memo[indx][buy]=Math.max(profit,skip);
    }
    public static int solveTab(int[] prices){
        int n=prices.length;
        int tab[][] =new int[n+1][2];
        Arrays.stream(tab).forEach(a->Arrays.fill(a,-1));
        tab[n][0]=0;
        tab[n][1]=0;

        int profit=0;
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=1;j++){
                if(j==1){
                    profit = Math.max(prices[i]+tab[i+1][0],tab[i+1][1]);
                }
                if(j==0){
                    profit = Math.max(-prices[i]+tab[i+1][1],tab[i+1][0]);
                }
                tab[i][j]=profit;
            }
        }  
        return tab[0][0];      
    }
}