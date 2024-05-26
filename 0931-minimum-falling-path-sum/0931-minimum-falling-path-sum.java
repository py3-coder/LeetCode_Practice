class Solution {
    static int[][] memo;
    public int minFallingPathSum(int[][] matrix) {
        
        int n  = matrix.length;
        if (n == 1) return matrix[0][0];
        //-100 <= matrix[i][j] <= 100
        memo = new int[n+1][n+1];
        Arrays.stream(memo).forEach(a->Arrays.fill(a,Integer.MAX_VALUE));
        // int mini  = Integer.MAX_VALUE;
        // for(int i=0;i<n;i++){
        //     mini = Math.min(mini , solveRec(0,i,n,matrix));
        // }
        //return mini;
        
        //return solveTab(matrix);
        
        return solveOpt(matrix);
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
    public int solveTab(int[][] matrix){
        int n  = matrix.length;
        int[][] tab = new int[n][n];
        
        for(int i=0;i<n;i++){
            tab[0][i] = matrix[0][i];
        }
        
        for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){
                int left =Integer.MAX_VALUE,right=Integer.MAX_VALUE;
                if(j>0){
                    left = tab[i-1][j-1];
                }
                int center = tab[i-1][j];
                if(j<n-1){
                    right = tab[i-1][j+1];
                }
                tab[i][j] =  matrix[i][j] + Math.min(left,Math.min(center,right));
            }
        }
        
        int maxi = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            maxi = Math.min(maxi, tab[n - 1][j]);
        }

        return maxi;
    }
    public int solveOpt(int[][] matrix){
        int n  = matrix.length;
        int[] prev = new int[n];
        
        for(int i=0;i<n;i++){
            prev[i] = matrix[0][i];
        }
        
        for(int i=1;i<n;i++){
            int[] temp = new int[n];
            for(int j=0;j<n;j++){
                int left =Integer.MAX_VALUE,right=Integer.MAX_VALUE;
                if(j>0){
                    left = prev[j-1];
                }
                int center = prev[j];
                if(j<n-1){
                    right = prev[j+1];
                }
                temp[j] =  matrix[i][j] + Math.min(left,Math.min(center,right));
            }
            prev = temp;
        }
        
        int maxi = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            maxi = Math.min(maxi, prev[j]);
        }

        return maxi;
    }
}