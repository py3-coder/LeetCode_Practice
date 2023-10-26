class Solution {
    static int memo[][] =new int[15001][501];
    public int maxSizeSlices(int[] slices) {
        // Similar to House Robber 2 :
        int n=slices.length;
        // int p1 =solveRec(slices,0,n-2,n/3);
        // int p2 =solveRec(slices,1,n-1,n/3);

        // Arrays.stream(memo).forEach(a->Arrays.fill(a,-1));
        // int p1 =solveMemo(slices,0,n-2,n/3);
        // Arrays.stream(memo).forEach(a->Arrays.fill(a,-1));
        // int p2 =solveMemo(slices,1,n-1,n/3);


        int p1 =solveTab(slices,0,n-2,n/3);
        int p2 =solveTab(slices,1,n-1,n/3);
        return Math.max(p1,p2);
    }
    public static int solveRec(int[] slices,int indx,int n,int k){
        //Base Case ::
        if(indx>n || k==0) return 0;
        
        int pick = slices[indx] +solveRec(slices,indx+2,n,k-1);
        int skip =solveRec(slices,indx+1,n,k);
        return Math.max(pick,skip);
    }
    public static int solveMemo(int[] slices,int indx,int n,int k){
        //Base Case ::
        if(indx>n || k==0) return 0;
        if(memo[indx][k]!=-1){
            return memo[indx][k];
        }
        int pick = slices[indx] +solveMemo(slices,indx+2,n,k-1);
        int skip =solveMemo(slices,indx+1,n,k);
        return memo[indx][k]=Math.max(pick,skip);
    }
    public static int solveTab(int[] slices,int i,int n,int s){
        int tab[][]= new int[n+3][s+1];
        for(int indx=n;indx>=i;indx--){
            for(int k=1;k<=s;k++){
                int pick = slices[indx]+tab[indx+2][k-1];
                int skip = tab[indx+1][k];
                tab[indx][k]=Math.max(pick,skip);
            }
        }
        return tab[i][s];
    }
}