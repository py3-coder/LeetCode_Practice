class Solution {
    static int[][] memo= new int[500][500];
    public int mincostTickets(int[] days, int[] costs) {
        //return solveRec(0,-1,days,costs);

        Arrays.stream(memo).forEach(a->Arrays.fill(a,-1));
        return solveMemo(0,0,days,costs);
        
    }
    public static int solveRec(int indx,int validity,int[] days,int[] cost){
        //Base Case::
        if(indx>=days.length) return 0;

        //choices based on validity::
        if(validity<days[indx]){
            int oneday = cost[0]+solveRec(indx+1,days[indx]+1-1,days,cost);
            int sevenday =cost[1] +solveRec(indx+1,days[indx]+7-1,days,cost);
            int thirtyday =cost[2]+solveRec(indx+1,days[indx]+30-1,days,cost);

            return Math.min(oneday,Math.min(sevenday,thirtyday));
        }else{
            return solveRec(indx+1,validity,days,cost);
        }
    }
    public static int solveMemo(int indx,int validity,int[] days,int[] cost){
        //Base Case::
        if(indx>=days.length) return 0;
        if(memo[indx][validity]!=-1){
            return memo[indx][validity];
        }
        //choices based on validity::
        if(validity<days[indx]){
            int oneday = cost[0]+solveMemo(indx+1,days[indx]+1-1,days,cost);
            int sevenday =cost[1] +solveMemo(indx+1,days[indx]+7-1,days,cost);
            int thirtyday =cost[2]+solveMemo(indx+1,days[indx]+30-1,days,cost);

            return memo[indx][validity]=Math.min(oneday,Math.min(sevenday,thirtyday));
        }else{
            return memo[indx][validity] =solveMemo(indx+1,validity,days,cost);
        }
    }

}