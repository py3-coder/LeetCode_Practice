class Solution {
    public int findChampion(int[][] grid) {
        int max=Integer.MIN_VALUE;
        int indx=0;
        for(int i=0;i<grid.length;i++){
            int cnt=0;
            for(int j=0;j<grid[0].length;j++){
                if(i!=j && grid[i][j]==1){
                    cnt++;
                }
            }
            if(max<cnt){
                max=cnt;
                indx=i;
            }
        }
        return indx;
    }
    
}