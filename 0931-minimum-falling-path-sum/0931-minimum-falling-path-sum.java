class Solution {
    static int[][] memo;
    public int minFallingPathSum(int[][] matrix) {
        
        int n  = matrix.length;
        if (n == 1) return matrix[0][0];
        
        memo = new int[n+1][n+1];
        Arrays.stream(memo).forEach(a->Arrays.fill(a,Integer.MAX_VALUE));
        int mini  = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            mini = Math.min(mini , solveRec(0,i,n,matrix));
        }
        return mini;
    }
    public int solveRec(int i,int j,int n,int[][] matrix){
        //base case ::
        if(i==n){
            return 0;
        }
        
        if(memo[i][j]!=Integer.MAX_VALUE){
            return memo[i][j];
        }
        
        int left =Integer.MAX_VALUE,right=Integer.MAX_VALUE;
        if(j>0){
            left = solveRec(i+1,j-1,n,matrix);
        }
        int center = solveRec(i+1,j,n,matrix);
        if(j<n-1){
            right = solveRec(i+1,j+1,n,matrix);
        }
        return memo[i][j] = matrix[i][j] + Math.min(left,Math.min(center,right));
    }
}