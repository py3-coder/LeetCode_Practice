class Solution {
    public void solve(char[][] board) {
        int n =board.length;
        int m=board[0].length;
        
        int[][] vis = new int[n][m];
        
        //Boundary Row:
        for(int j=0;j<m;j++){
            if(board[0][j]=='O' && vis[0][j]!=1){
                dfs(0,j,vis,board);
            }
            if(board[n-1][j]=='O' && vis[n-1][j]!=1){
                dfs(n-1,j,vis,board);
            }
        }
        for(int i=0;i<n;i++){
            if(board[i][0]=='O' && vis[i][0]!=1){
                dfs(i,0,vis,board);
            }
            if(board[i][m-1]=='O' && vis[i][m-1]!=1){
                dfs(i,m-1,vis,board);
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O' && vis[i][j]==0){
                    board[i][j]='X';
                }
            }
        }
        return ;
    }
    public static void dfs(int row,int col,int[][] vis,char[][] board){
        vis[row][col]=1;
        
        int n =board.length;
        int m=board[0].length;
        
        int drow[] ={0,1,0,-1};
        int dcol[] ={1,0,-1,0};
        
        for(int i=0;i<4;i++){
            int nrow =row+drow[i];
            int ncol =col+dcol[i];
            
            if(nrow<n && nrow>=0 && ncol>=0 && ncol<m && vis[nrow][ncol]!=1 && board[nrow][ncol]=='O'){
                dfs(nrow,ncol,vis,board);
            }
        }
    }
}