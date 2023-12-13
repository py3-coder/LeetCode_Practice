class Solution {
    public int numEnclaves(int[][] board) {
        int n =board.length;
        int m=board[0].length;
        
        int[][]  vis =new int[n][m];
        
        //Boundary DFS :::
        for(int j=0;j<m;j++){
            if(board[0][j]==1 && vis[0][j]!=1){
                dfs(0,j,vis,board);
            }
            if(board[n-1][j]==1 && vis[n-1][j]!=1){
                dfs(n-1,j,vis,board);
            }
        }
        for(int i=0;i<n;i++){
            if(board[i][0]==1 && vis[i][0]!=1){
                dfs(i,0,vis,board);
            }
            if(board[i][m-1]==1 && vis[i][m-1]!=1){
                dfs(i,m-1,vis,board);
            }
        }
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && board[i][j]==1){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public static void dfs(int row,int col ,int[][] vis,int[][] board){
        vis[row][col]=1;
        
        int n =board.length;
        int m=board[0].length;
        
        int drow[] ={0,1,0,-1};
        int dcol[] ={1,0,-1,0};
        
        for(int i=0;i<4;i++){
            int nrow =row+drow[i];
            int ncol =col+dcol[i];
            
            if(nrow<n && nrow>=0 && ncol>=0 && ncol<m && vis[nrow][ncol]!=1 && board[nrow][ncol]==1){
                dfs(nrow,ncol,vis,board);
            }
        }
    }
    
}