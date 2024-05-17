class Solution {
    static int[][] memo;
    public int change(int amount, int[] coins) {
        int n = coins.length;
        memo = new int[n+1][amount+1];
        Arrays.stream(memo).forEach(a->Arrays.fill(a,-1));
        
        return solveRec(n,amount,coins);
    }
    public int solveRec(int n,int amt,int[] coins){
        //Base Case ::
        if(amt==0){
            return 1;
        }
        if(n<=0){
            return 0;
        }
        if(memo[n][amt]!=-1){
            return memo[n][amt];
        }
        
        if(coins[n-1]>amt){
            //can't pick :
            return memo[n][amt]= solveRec(n-1,amt,coins);
        }else{
            return  memo[n][amt]=solveRec(n,amt-coins[n-1],coins) + solveRec(n-1,amt,coins);
        }
    }
}