class Solution {
    public int matrixScore(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        //Broute Force -- 
        // TC : O(n^2)
        // SC : O(m)
        //return solveBrouteForce(n,m,grid);
    
        //Optimisation :-
        return solveOpt(n,m,grid);
        
    }
    public int solveOpt(int n ,int m , int[][] grid){
        int res =0;
        
        res += (1<<(m-1))*n;
        
        for(int j=1;j<m;j++){
            int same =0;
            for(int i=0;i<n;i++){
                if(grid[i][0] == grid[i][j]){
                    same++;
                }
            }
            res += (1<<(m-1-j))*Math.max(same,n-same);
        }
        
        return res;
    }
    public int solveBrouteForce(int n,int m ,int[][] grid){
        for(int i=0;i<n;i++){
            if(grid[i][0]==0){
                flipRows(grid,i);
            }
        }
        
        
        // cnt of zeros in every colum ::
        int[] cnter = new int[m];
        for(int i=0;i<m;i++){
            int cnt=0;
            for(int j=0;j<n;j++){
                if(grid[j][i]==0){
                    cnt++;
                }
            }
            cnter[i]=cnt;
        }
        
        for(int i=0;i<m;i++){
            if(cnter[i]>n/2){
                flipCols(grid,i);
            }
        }
        
        
        //Calculate Sum ::
        int sum=0;
        for(int[] ele : grid){
            int p =m-1;
            for(int j=0;j<m;j++){
                int val = (int)Math.pow(2,p);
                sum += val *ele[j];
                p--;
            }
        }
        return sum;
    }
    public void flipRows(int[][] grid ,int i){
        for(int j=0;j<grid[0].length;j++){
            if(grid[i][j]==0){
                grid[i][j]=1;
            }else{
                grid[i][j]=0;
            }
        }
    }
    
    public void flipCols(int[][] grid,int i){
        for(int j=0;j<grid.length;j++){
            if(grid[j][i]==0){
                grid[j][i]=1;
            }else{
                grid[j][i]=0;
            }
        }
    }
}