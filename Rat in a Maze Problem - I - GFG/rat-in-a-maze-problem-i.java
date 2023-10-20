//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        //lets Play with backtracking:)
        ArrayList<String> res = new ArrayList<>();
        int[][] vis = new int[n][n];
        //edge case ::
        if(m[0][0]!=1){
            return res;
        }
        solve(n,0,0,m,vis,"",res);
        return res;
    }
    public static void solve(int n,int x,int y,int[][] m,int[][] vis,String path,ArrayList<String> res){
        if(x==n-1 && y==n-1){
            res.add(path);
            return;
        }
        // We have 4 choices ::
        // D L R U
        // Lets try all path::
        // Down
        if(isSafe(n,x+1,y,m,vis)){
            vis[x][y]=1;
            solve(n,x+1,y,m,vis,path+'D',res);
            vis[x][y]=0;
        }
        //Left
        if(isSafe(n,x,y-1,m,vis)){
            vis[x][y]=1;
            solve(n,x,y-1,m,vis,path+'L',res);
            vis[x][y]=0;
        }
        //Right:
        if(isSafe(n,x,y+1,m,vis)){
            vis[x][y]=1;
            solve(n,x,y+1,m,vis,path+'R',res);
            vis[x][y]=0;
        }
        //UP
        if(isSafe(n,x-1,y,m,vis)){
            vis[x][y]=1;
            solve(n,x-1,y,m,vis,path+'U',res);
            vis[x][y]=0;
        }
    }
    public static boolean isSafe(int n,int newx,int newy,int[][] m,int[][] vis){
        if((newx>=0 && newx<n) && (newy>=0 && newy<n) && m[newx][newy]!=0 && vis[newx][newy]!=1){
            return true;
        }
        return false;
    }
}