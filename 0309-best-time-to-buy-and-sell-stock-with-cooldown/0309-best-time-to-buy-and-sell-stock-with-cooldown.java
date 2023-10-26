class Solution {
    static int memo[][] = new int[5001][2];
    public int maxProfit(int[] prices) {
        //Recursion:)
        //return solveRec(prices,0,0);

        //Memoisation:)
        // Arrays.stream(memo).forEach(a->Arrays.fill(a,-1));
        // return solveMemo(prices,0,0);

        //return solveTab(prices);


        return solveTabOpt(prices);
    }
    private int solveRec(int[] prices ,int indx,int buy){
        //Base Case ::
        if(indx>=prices.length) return 0;
        int profit=0;
        if(buy==0 ){
            profit =Math.max(-prices[indx]+solveRec(prices,indx+1,1),solveRec(prices,indx+1,0));
        }else{
            profit =Math.max(prices[indx]+solveRec(prices,indx+2,0),solveRec(prices,indx+1,1));
        }
        return profit;
    }
    private int solveMemo(int[] prices ,int indx,int buy){
        //Base Case ::
        if(indx>=prices.length) return 0;

        if(memo[indx][buy]!=-1){
            return memo[indx][buy];
        }
        int profit=0;
        if(buy==0 ){
            profit =Math.max(-prices[indx]+solveMemo(prices,indx+1,1),solveMemo(prices,indx+1,0));
        }else{
            profit =Math.max(prices[indx]+solveMemo(prices,indx+2,0),solveMemo(prices,indx+1,1));
        }
        return memo[indx][buy]=profit;
    } 
    private int solveTab(int[] prices){
        //Tabulation::)
        int n =prices.length;
        int tab[][] = new int[n+2][2];

        for(int indx=n-1;indx>=0;indx--){
            for(int j=0;j<=1;j++){
                if(j==0 ){
                    tab[indx][j]=Math.max(-prices[indx]+tab[indx+1][1],tab[indx+1][0]);
                }
                if(j==1){
                    tab[indx][j]=Math.max(prices[indx]+tab[indx+2][0],tab[indx+1][1]);
                }
            }
        }
        return tab[0][0];
    } 
    private int solveTabOpt(int[] prices){
        //Tabulation::)
        int n =prices.length;
        int tab[][] = new int[n+2][2];

        for(int indx=n-1;indx>=0;indx--){
            tab[indx][0]=Math.max(-prices[indx]+tab[indx+1][1],tab[indx+1][0]);
            tab[indx][1]=Math.max(prices[indx]+tab[indx+2][0],tab[indx+1][1]);
        }
        return tab[0][0];
    }
    
}