class Solution {
    public int[][] imageSmoother(int[][] img) {
        int n =img.length;
        int m =img[0].length;
        
        int[][] res = new int[n][m];
        int[] drow={0,0,1,1,1,0,-1,-1,-1};
        int[] dcol={0,1,1,0,-1,-1,-1,0,1};
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int cnt=0;
                int sum=0;
                for(int k=0;k<9;k++){
                    int nrow =i+drow[k];
                    int ncol =j+dcol[k];
                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<m){
                        cnt++;
                        sum+=img[nrow][ncol];
                    }
                }
                res[i][j]=sum/cnt;
            }
        }
        return res;
    }
}