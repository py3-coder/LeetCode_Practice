class Solution {
    static int[][] memo= new int[500][500];
    static int[]memoB= new int[366];
    public int mincostTickets(int[] days, int[] costs) {
        //Recursion :: TC =O(3^n)
        // SC : O(1)+O(n)
        //return solveRec(0,-1,days,costs);

        // Memoisation ::
        // TC : O(n*n)
        // SC: O(n*n) +O(n)
        // Arrays.stream(memo).forEach(a->Arrays.fill(a,-1));
        // return solveMemo(0,0,days,costs);
        Arrays.fill(memoB,-1);
        return solveMemoBS(0,days,costs);
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
    public static int solveMemoBS(int indx,int[] days,int[] cost){
        //Base Case::
        if(indx>=days.length) return 0;
        if(memoB[indx]!=-1){
            return memoB[indx];
        }
        int day = binarySearch(indx,days[indx]+1,days);
        int oneday = cost[0]+solveMemoBS(day,days,cost);
        
        day =binarySearch(indx,days[indx]+7,days);
        int sevenday =cost[1] +solveMemoBS(day,days,cost);

        day =binarySearch(indx,days[indx]+30,days);
        int thirtyday =cost[2]+solveMemoBS(day,days,cost);

        return memoB[indx]=Math.min(oneday,Math.min(sevenday,thirtyday));
        
    }
    //trying to find the first target index if not present first greatest value index to it::
    public static int binarySearch(int low,int target,int days[]){
        int high=days.length-1;
        while(low<=high){
            int mi =low+(high-low)/2;
            if(days[mi]==target){
                return mi;
            }else if(days[mi]>target){
                high=mi-1;
            }else{
                low=mi+1;
            }
        }
        return low;
    }

}