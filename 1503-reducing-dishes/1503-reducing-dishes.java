class Solution {
    static int memo[][] = new int[501][501];
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        //return solveRec(satisfaction,0,1);

        Arrays.stream(memo).forEach(a->Arrays.fill(a,-1));
        return solveMemo(satisfaction,0,1);
        
    }
    public static int solveRec(int[] value,int indx,int curr){
        //Base Case ::
        if(indx>=value.length) return 0;

        // choices we have ::2-- pick the dices / not pick the dices::
        int pick=0,notpick=0;
        pick = value[indx]*curr+solveRec(value,indx+1,curr+1);
        notpick =solveRec(value,indx+1,curr);
        return Math.max(pick,notpick);
    }
    public static int solveMemo(int[] value,int indx,int curr){
        //Base Case ::
        if(indx>=value.length) return 0;
        if(memo[indx][curr]!=-1){
            return memo[indx][curr];
        }

        // choices we have ::2-- pick the dices / not pick the dices::
        int pick=0,notpick=0;
        pick = value[indx]*curr+solveMemo(value,indx+1,curr+1);
        notpick =solveMemo(value,indx+1,curr);
        return memo[indx][curr]=Math.max(pick,notpick);
    }
}