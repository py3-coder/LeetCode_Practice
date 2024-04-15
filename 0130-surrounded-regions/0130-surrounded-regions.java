class Solution {
    public void solve(char[][] board) {
        // Boundary DFS ::
        int n =board.length;
        int m =board[0].length;
        
        int[][] vis = new int[n][m];
        
        // Topleft->right
        for(int i=0;i<m;i++){
            if(board[0][i]=='O' && vis[0][i]!=1){
                dfs(0,i,vis,board);
            }
        }
        //Topleft -> bottom left
        for(int i=1;i<n;i++){
            if(board[i][0]=='O' && vis[i][0]!=1){
                dfs(i,0,vis,board);
            }
        }
        
        // bootom left -> bottom right
        for(int i=0;i<m;i++){
            if(board[n-1][i]=='O' && vis[n-1][i]!=1){
                dfs(n-1,i,vis,board);
            }
        }
        
        // Top right -> bottom right
        for(int i=0;i<n;i++){
            if(board[i][m-1]=='O' && vis[i][m-1]!=1){
                dfs(i,m-1,vis,board);
            }
        }
        
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]!=1 && board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }
    
    public void dfs(int row,int col ,int[][] vis,char[][] board){
        vis[row][col]=1;
        
        int[] dx ={1,0,-1,0};
        int[] dy ={0,1,0,-1};
        
        for(int i=0;i<4;i++){
            int nr =row+dx[i];
            int nc =col+dy[i];
            
            if(nr<board.length && nr>=0 && nc<board[0].length && nc>=0 && board[nr][nc]=='O' && vis[nr][nc]!=1){
                dfs(nr,nc,vis,board);
            }
        }
    }
}