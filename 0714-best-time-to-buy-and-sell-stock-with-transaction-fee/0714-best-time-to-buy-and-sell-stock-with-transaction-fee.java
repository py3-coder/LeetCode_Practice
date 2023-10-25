class Solution {
    static int memo[][] =new int[50001][2];
    public int maxProfit(int[] prices, int fee) {
        //Recursion::)
        //return solveRec(prices,0,1,fee);

        // Arrays.stream(memo).forEach(a->Arrays.fill(a,-1));
        // return solveMemo(prices,0,1,fee);

        return solveTab(prices,fee);
        
    } 
    public static int solveRec(int[] prices ,int indx,int buy,int fee){
        //Base Case ::
        if(indx==prices.length) return 0;
        int profit=0;
        if(buy==1){
            profit = -prices[indx]-fee+solveRec(prices,indx+1,0,fee);
        }else{
            profit =prices[indx]+solveRec(prices,indx+1,1,fee);
        }
        int skip =solveRec(prices,indx+1,buy,fee);
        return Math.max(profit,skip);
    }
    public static int solveMemo(int[] prices,int indx,int buy,int fee){
        //Base Case ::
        if(indx==prices.length) return 0;
        if(memo[indx][buy]!=-1){
            return memo[indx][buy];
        }
        int profit=0;
        if(buy==1){
            profit = -prices[indx]-fee+solveMemo(prices,indx+1,0,fee);
        }else{
            profit =prices[indx]+solveMemo(prices,indx+1,1,fee);
        }
        int skip =solveMemo(prices,indx+1,buy,fee);
        return Math.max(profit,skip);
    }
    public static int solveTab(int[] prices,int fee){
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
                    profit = Math.max(-prices[i]-fee+tab[i+1][1],tab[i+1][0]);
                }
                tab[i][j]=profit;
            }
        }  
        return tab[0][0];      
    }
    
}