class Solution {
    public int minimumEffortPath(int[][] heights) {
        // Lets Apply BFS -- Djisktra Algo :::
        int n=heights.length;
        int m=heights[0].length;
        PriorityQueue<Triple> pq = new PriorityQueue<>((a,b)->(a.diff-b.diff));
        pq.offer(new Triple(0,0,0));
        int[][] dist =new int[n][m];
        
        Arrays.stream(dist).forEach(a->Arrays.fill(a,(int)1e9));
        dist[0][0]=0;
        while(!pq.isEmpty()){
            Triple curr = pq.poll();
            int diff =curr.diff;
            int row  =curr.row;
            int col  =curr.col;
            //System.out.println(row+" "+col);
            if(row==n-1 && col==m-1) return diff;
            
            int[] drow ={0,1,0,-1};
            int[] dcol ={1,0,-1,0};
            
            for(int i=0;i<4;i++){
                int nrow =drow[i]+row;
                int ncol =dcol[i]+col;
                
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m){
                    int newabsdiff = Math.max(Math.abs(heights[row][col]-heights[nrow][ncol]),diff);
                    if(newabsdiff<dist[nrow][ncol]){
                        dist[nrow][ncol]=newabsdiff;
                         pq.offer(new Triple(newabsdiff,nrow,ncol));
                    }
                   
                }
            }
        }
        return 0;
    }
    class Triple{
        int diff;
        int row;
        int col;
        Triple(int _diff,int _row,int _col){
            this.diff =_diff;
            this.row =_row;
            this.col =_col;
        }
    }
}

//     public int minimumEffortPath(int[][] heights) {
//         PriorityQueue<Cell>pq=new PriorityQueue<>((x,y)->x.dist-y.dist);
//         int row=heights.length;
//         int col=heights[0].length;
//         int diff[][]=new int[row][col];
//         for(int arr[]:diff){
//             Arrays.fill(arr,Integer.MAX_VALUE);
//         }
//         diff[0][0]=0;
//         pq.add(new Cell(0,0,0));
//         while(!pq.isEmpty()){
//             Cell temp=pq.remove();
//             int distance=temp.dist;
//             int r=temp.row;
//             int c=temp.col;
//             int rp[]={-1,1,0,0};
//             int cp[]={0,0,-1,1};
           
//             if(r==row-1&&c==col-1)return distance;
//             for(int i=0;i<4;i++){
//                 int r1=r+rp[i];
//                 int c1=c+cp[i];
//                 if(r1>=0&&r1<row&&c1>=0&&c1<col){
//                     int minEff=Math.max(Math.abs(heights[r1][c1]-heights[r][c]),distance);
//                     if(minEff<diff[r1][c1]){
//                         diff[r1][c1]=minEff;
//                         pq.add(new Cell(r1,c1,minEff));
//                     }
//                 }

//             }
//         }
//         return -1;
//     }
