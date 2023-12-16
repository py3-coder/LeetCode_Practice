//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] S = read.readLine().split(" ");
            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);
            int Grid[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String[] s = read.readLine().split(" ");
                for (int j = 0; j < M; j++) Grid[i][j] = Integer.parseInt(s[j]);
            }
            Solution ob = new Solution();
            System.out.println(ob.MinimumEffort(Grid));
        }
    }
}
// } Driver Code Ends


class Solution {
    
    int MinimumEffort(int heights[][]) {
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
    static class Triple{
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