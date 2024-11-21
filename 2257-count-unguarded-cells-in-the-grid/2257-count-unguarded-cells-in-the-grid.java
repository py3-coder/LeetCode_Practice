class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        char[][] matrix = new char[m][n];
        int ans = m*n-guards.length-walls.length;
        
        for(int[] wall : walls){
            matrix[wall[0]][wall[1]]='W';
        }
        for(int[] guard : guards){
            matrix[guard[0]][guard[1]]='G';
        }
        
        for(int[] point : guards){
            for(int[] dir : dirs){
                int nrow =point[0]+dir[0];
                int ncol =point[1]+dir[1];
                
                while(!(nrow<0 || ncol<0 || nrow>=m || ncol>=n ||
                        matrix[nrow][ncol]=='G' || matrix[nrow][ncol]=='W')){
                    
                    if(matrix[nrow][ncol]!='P'){
                        ans--;
                    }
                    matrix[nrow][ncol]='P';
                    nrow +=dir[0];
                    ncol +=dir[1];
                }
            }
        }
        return ans;
    }
}