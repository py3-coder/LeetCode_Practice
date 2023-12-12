class Solution {
    public int numIslands(char[][] grid){
        int n=grid.length;
        int m=grid[0].length;
		int[][] vis =new int[n][m];
		int cnt=0;
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(grid[i][j]=='1' && vis[i][j]!=1){
					cnt++;
					bfs(i,j,vis,grid);
				}
			}
		}
		return cnt;

	}
	public static void bfs(int row,int col,int[][] vis,char[][] grid){
		int n=grid.length;
        int m=grid[0].length;
		Queue<Pair> que = new LinkedList<>();
		que.offer(new Pair(row,col));

		int drow[] ={0,1,0,-1};
		int dcol[] ={1,0,-1,0};

		while(!que.isEmpty()){
			Pair pp =que.poll();
			int r =pp.val1;
			int c=pp.val2;
			for(int i=0;i<4;i++){
				int nrow =r+drow[i];
				int ncol =c+dcol[i];
				if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]!=1 && grid[nrow][ncol]=='1'){
					que.offer(new Pair(nrow,ncol));
					vis[nrow][ncol]=1;
				}
			}
		}
		return ;
	}
	static class Pair{
		int val1;
		int val2;

		Pair(int _val1,int _val2){
			this.val1=_val1;
			this.val2=_val2;
		}
	}
}