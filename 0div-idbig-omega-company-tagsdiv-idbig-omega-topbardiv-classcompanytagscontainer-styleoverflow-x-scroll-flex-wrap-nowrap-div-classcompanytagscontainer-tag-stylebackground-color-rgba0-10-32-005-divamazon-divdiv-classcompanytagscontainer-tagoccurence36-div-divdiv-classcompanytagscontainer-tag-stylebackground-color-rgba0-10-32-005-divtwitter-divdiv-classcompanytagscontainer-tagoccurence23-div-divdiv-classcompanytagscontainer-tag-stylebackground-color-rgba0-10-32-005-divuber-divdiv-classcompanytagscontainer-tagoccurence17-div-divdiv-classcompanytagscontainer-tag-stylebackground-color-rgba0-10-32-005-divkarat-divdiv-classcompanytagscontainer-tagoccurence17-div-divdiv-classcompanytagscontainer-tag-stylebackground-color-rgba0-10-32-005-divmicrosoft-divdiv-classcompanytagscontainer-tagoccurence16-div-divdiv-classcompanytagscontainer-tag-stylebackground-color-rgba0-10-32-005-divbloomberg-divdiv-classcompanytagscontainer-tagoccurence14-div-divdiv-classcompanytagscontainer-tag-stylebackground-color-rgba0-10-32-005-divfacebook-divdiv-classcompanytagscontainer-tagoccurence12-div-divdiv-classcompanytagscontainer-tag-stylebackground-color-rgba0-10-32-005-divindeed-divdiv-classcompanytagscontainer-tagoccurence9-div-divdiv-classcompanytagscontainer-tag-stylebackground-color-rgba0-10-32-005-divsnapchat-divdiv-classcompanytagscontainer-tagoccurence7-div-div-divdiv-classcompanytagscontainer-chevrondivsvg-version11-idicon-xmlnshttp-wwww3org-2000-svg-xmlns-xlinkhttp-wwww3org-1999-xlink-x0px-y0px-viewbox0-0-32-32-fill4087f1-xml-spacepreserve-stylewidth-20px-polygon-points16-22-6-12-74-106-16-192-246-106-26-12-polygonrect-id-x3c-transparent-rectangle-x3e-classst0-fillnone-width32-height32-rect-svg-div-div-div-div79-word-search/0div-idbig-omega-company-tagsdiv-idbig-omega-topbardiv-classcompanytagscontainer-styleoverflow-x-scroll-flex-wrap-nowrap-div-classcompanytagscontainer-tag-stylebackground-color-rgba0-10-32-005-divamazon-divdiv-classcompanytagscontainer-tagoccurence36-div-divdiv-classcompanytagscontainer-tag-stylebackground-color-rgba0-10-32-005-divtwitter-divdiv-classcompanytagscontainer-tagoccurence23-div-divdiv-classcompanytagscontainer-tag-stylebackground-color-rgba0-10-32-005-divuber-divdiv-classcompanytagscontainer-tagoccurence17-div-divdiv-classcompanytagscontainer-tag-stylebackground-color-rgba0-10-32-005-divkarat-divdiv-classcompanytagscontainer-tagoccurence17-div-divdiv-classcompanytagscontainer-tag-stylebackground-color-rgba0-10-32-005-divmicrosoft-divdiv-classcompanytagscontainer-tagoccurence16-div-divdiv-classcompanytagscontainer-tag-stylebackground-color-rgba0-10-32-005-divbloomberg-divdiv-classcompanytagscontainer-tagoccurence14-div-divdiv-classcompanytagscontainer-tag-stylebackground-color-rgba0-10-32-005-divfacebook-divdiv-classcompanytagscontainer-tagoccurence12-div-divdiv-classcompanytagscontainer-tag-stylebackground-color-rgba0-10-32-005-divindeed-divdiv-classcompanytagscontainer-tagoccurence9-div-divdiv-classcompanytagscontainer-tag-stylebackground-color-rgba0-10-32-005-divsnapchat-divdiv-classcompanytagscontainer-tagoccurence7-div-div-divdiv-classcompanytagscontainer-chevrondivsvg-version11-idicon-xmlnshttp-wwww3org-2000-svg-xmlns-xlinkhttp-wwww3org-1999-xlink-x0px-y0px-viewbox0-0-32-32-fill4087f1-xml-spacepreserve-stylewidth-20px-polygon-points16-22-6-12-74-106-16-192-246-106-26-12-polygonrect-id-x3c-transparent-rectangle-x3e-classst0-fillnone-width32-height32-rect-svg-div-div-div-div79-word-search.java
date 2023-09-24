class Solution {
    public boolean exist(char[][] board, String word) {
        //Lets Play with recursion::::
        return getfirstchar(board,word);
        
    }
    public static boolean getfirstchar(char[][] board,String word){
        int m=board.length;
        int n=board[0].length;
        int indx=0;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == word.charAt(indx)){
                    if(searchCharacter(board,word,indx,i,j,m,n))
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean searchCharacter(char[][] board,String word,int indx,int row,int col,int m,int n){
        if(indx==word.length()){
            return true;
        }
        if(row<0 || col<0 || row==m || col==n || board[row][col]!=word.charAt(indx) || board[row][col]=='!'){
            return false;
        }
        //let mark the visted one::
        char ch =board[row][col];
        board[row][col] ='!';
        
        //top -- bottom --left --right 
        boolean top =searchCharacter(board,word,indx+1,row-1,col,m,n);
        boolean bottom =searchCharacter(board,word,indx+1,row+1,col,m,n);
        boolean left =searchCharacter(board,word,indx+1,row,col-1,m,n);
        boolean right =searchCharacter(board,word,indx+1,row,col+1,m,n);
        
        board[row][col] =ch;
        
        return top || bottom || left || right;
        
    }
}