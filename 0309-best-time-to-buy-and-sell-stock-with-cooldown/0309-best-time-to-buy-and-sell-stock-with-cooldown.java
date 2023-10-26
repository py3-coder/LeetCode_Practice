class Solution {
    static int memo[][] = new int[5001][2];
    public int maxProfit(int[] prices) {
        //Recursion:)
        //return solveRec(prices,0,0);

        //Memoisation:)
        Arrays.stream(memo).forEach(a->Arrays.fill(a,-1));
        return solveMemo(prices,0,0);
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
}