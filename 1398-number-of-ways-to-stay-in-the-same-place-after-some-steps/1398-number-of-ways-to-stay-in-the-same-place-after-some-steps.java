class Solution {
    private static final int mod = 1000000007;
    static long[][] memo = new long[501][501];
    public int numWays(int steps, int arrLen) {
        // Recursion:) - TLE
        //return solveRec(steps,arrLen,0);

        //Memo:
        Arrays.stream(memo).forEach(a->Arrays.fill(a,-1));
        return (int)solveMemo(steps,arrLen,0)%mod;
        
    }
    public static int solveRec(int steps,int arrlen,int pos){
        //Base Case ::
        if(steps==0){
            if(pos==0) return 1;
            return 0;
        }
        //choices not posssible:)
        if(pos<0 || pos==arrlen || pos>steps) return 0;
        //choices we can make::
        int left =solveRec(steps-1,arrlen,pos-1);
        int right=solveRec(steps-1,arrlen,pos+1);
        int stay =solveRec(steps-1,arrlen,pos);;
        return left+right+stay;
    }
    public static long solveMemo(int steps,int arrlen,int pos){
        //Base Case ::
        if(steps==0){
            if(pos==0) return 1;
            return 0;
        }
        //choices not posssible:)
        if(pos<0 || pos>=arrlen) return 0;

        if(memo[steps][pos]!=-1){
            return memo[steps][pos];
        }
        //choices we can make:
        long left =solveMemo(steps-1,arrlen,pos-1)%mod;
        long right=solveMemo(steps-1,arrlen,pos+1)%mod;
        long stay =solveMemo(steps-1,arrlen,pos)%mod;
        return memo[steps][pos]=(left+right+stay)%mod;
    }
}