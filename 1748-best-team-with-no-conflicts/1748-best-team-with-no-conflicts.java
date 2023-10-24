class Solution {
    static int memo[][] = new int[1001][1002];
    public int bestTeamScore(int[] scores, int[] ages) {
        int n=scores.length;
        int map[][]=new int[n][2];

        for(int i=0;i<n;i++){
            map[i][0] =ages[i];
            map[i][1] =scores[i];
        }   
        Arrays.sort(map,(a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        //return solveRec(map,-1,0);

        Arrays.stream(memo).forEach(a->Arrays.fill(a,-1));
        return solveMemo(map,-1,0);
        
    }
    public static int solveRec(int[][] arr,int prev,int indx){
        if(indx>=arr.length){
            return 0;
        }
        int pick=0;
        if(prev==-1 || arr[indx][0]==arr[prev][0]){
            pick = arr[indx][1] + solveRec(arr,indx,indx+1);
        }
        else if(arr[indx][0]>arr[prev][0] && arr[indx][1]>=arr[prev][1]){
            pick = arr[indx][1] +solveRec(arr,indx,indx+1);
        }
        int notpick = solveRec(arr,prev,indx+1);
        return Math.max(pick,notpick);
    }
    public static int solveMemo(int[][] arr,int prev,int indx){
        if(indx>=arr.length){
            return 0;
        }
        if(memo[indx][prev+1]!=-1){
            return memo[indx][prev+1];
        }
        int pick=0;
        if(prev==-1 || arr[indx][0]>=arr[prev][0] && arr[indx][1]>=arr[prev][1]){
            pick = arr[indx][1] + solveMemo(arr,indx,indx+1);
        }
        int notpick = solveMemo(arr,prev,indx+1);
        return memo[indx][prev+1]=Math.max(pick,notpick);
    }
}