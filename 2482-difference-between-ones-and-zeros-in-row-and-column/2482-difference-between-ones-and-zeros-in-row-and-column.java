class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int n =grid.length;
        int m =grid[0].length;
        
       int[] rowi =new int[n];
       int[] coli =new int[m];
        
        for(int i=0;i<n;i++){
            int cnt1=0;
            int cnt0=0;
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    cnt1++;
                }else{
                    cnt0++;
                }
            }
            rowi[i]=cnt1-cnt0;
        }
        for(int j=0;j<m;j++){
            int cnt1=0;
            int cnt0=0;
            for(int i=0;i<n;i++){
                if(grid[i][j]==1){
                    cnt1++;
                }else{
                    cnt0++;
                }
            }
            coli[j]= cnt1-cnt0;;
        }
        
        int[][] diff = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                //System.out.println(rowi[i]+","+coli[j]);
                diff[i][j] = rowi[i]+coli[j];
            }
        }
        return diff;
    }
}