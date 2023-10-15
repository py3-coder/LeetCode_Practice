class Solution {
    static long memo[][] = new long[5001][1002];
    static int mod =1000000007;
    public int numberOfWays(int startPos, int endPos, int k) {
        //Recursion:)
       // return solveRec(startPos,endPos,k);
       Arrays.stream(memo).forEach(a->Arrays.fill(a,-1));
       return (int) solveMemo(startPos,endPos,k);
        
    }
    public static int solveRec(int startPos,int endPos,int k){
        //Base Case ::
        if(k==0){
            if(startPos==endPos) return 1;
            return 0;
        }
        
        int left =solveRec(startPos-1,endPos,k-1);
        int right =solveRec(startPos+1,endPos,k-1);
        return left+right;
    }
    public static long solveMemo(int startPos,int endPos,int k){
        //Base Case ::
        if(k==0){
            if(startPos==endPos) return 1;
            return 0;
        }
        if(memo[startPos+1000][k]!=-1){
            return memo[startPos+1000][k];
        }
        
        long left =solveMemo(startPos-1,endPos,k-1)%mod;
        long right =solveMemo(startPos+1,endPos,k-1)%mod;
        return memo[startPos+1000][k]=(left+right)%mod;
    }
}