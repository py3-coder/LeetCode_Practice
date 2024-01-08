class Solution {
    public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
        int[][] dr ={{0,1},{1,0},{-1,0},{0,-1}};
        int[][] db ={{1,1},{1,-1},{-1,1},{-1,-1}};
        
        int row ,col;
        //rook moves ::
        for(int[] temp :dr){
            row =a;
            col=b;
            
            while(true){
                row+=temp[0];
                col+=temp[1];
                //check boundray case::
                if(row<0 || row>=9 || col>=9 || col<0){
                    break;
                }
                else if(row ==c  && col ==d){
                    break;
                }
                if(row == e && col ==f){
                    return 1;
                }
            }
        }
        
        //bishop moves::
        for(int[] temp :db){
            row =c;
            col=d;
            
            while(true){
                row+=temp[0];
                col+=temp[1];
                //check boundray case::
                if(row<0 || row>=9 || col>=9 || col<0){
                    break;
                }
                else if(row ==a  && col ==b){
                    break;
                }
                if(row == e && col ==f){
                    return 1;
                }
            }
        }
        //
        return 2;
        
    }
}