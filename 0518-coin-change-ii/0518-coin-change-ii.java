class Solution {
    static int[][] memo;
    public int change(int amount, int[] coins) {
        int n = coins.length;
        memo = new int[n+1][amount+1];
        Arrays.stream(memo).forEach(a->Arrays.fill(a,-1));
        
        //return solveRec(n,amount,coins);
        
        //return solveTab(n,amount,coins);
        
        return solveOpt(n,amount,coins);
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
    public int solveTab(int n,int amt ,int[] coins){
        int[][] tab = new int[n+1][amt+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<amt+1;j++){
                if(j==0){
                    tab[i][j] = 1;
                }
                if(i==0){
                    tab[i][j]=0;
                }
            }
        }
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=amt;j++){
                if(coins[i-1]>j){
                    tab[i][j] = tab[i-1][j];
                }else{
                    tab[i][j] = tab[i][j-coins[i-1]] + tab[i-1][j];
                }
            }
        }
        
        return tab[n][amt];
    }
    
    public int solveOpt(int n,int amt ,int[] coins){
        int[] curr = new int[amt+1];
        int[] prev = new int[amt+1];
        
        curr[0]=1;
        prev[0]=1;
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=amt;j++){
                if(coins[i-1]>j){
                    curr[j] = prev[j];
                }else{
                    curr[j] = curr[j-coins[i-1]] + prev[j];
                }
            }
            
            for(int k=0;k<amt+1;k++){
                prev[k] = curr[k];
            }
        }
        
        return curr[amt];
    }
}