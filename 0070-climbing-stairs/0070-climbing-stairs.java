class Solution {
    static int memo[]= new int[46];
    public int climbStairs(int n) {
        //Lets Play With Recursion::
        //1. Recursion::
        //return solveRec(n);
        
        //2. Memo:
        Arrays.fill(memo,-1);
        return solveMemo(n);

    }
    public static int solveRec(int n){
        //Base Case ::
        if(n<0) return 0;
        if(n==0) return 1;
        //choice diagram ::
        // either 1 steps or 2 steps :: since we are counting the ways:: just add it:
        if(n<2){
            return solveRec(n-1);
        }
        return solveRec(n-1)+solveRec(n-2);
    }
    public static int solveMemo(int n){
        //Base Case ::
        if(n<0) return 0;
        if(n==0) return 1;
        if(memo[n]!=-1){
            return memo[n];
        }
        //choice diagram ::
        // either 1 steps or 2 steps :: since we are counting the ways:: just add it:
        if(n<2){
            return memo[n]=solveMemo(n-1);
        }
        return memo[n]=solveMemo(n-1)+solveMemo(n-2);
    }
}