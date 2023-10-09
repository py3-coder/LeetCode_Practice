class Solution {
    static int[][] memo = new int[1001][1001];
    public int numDistinct(String s, String t) {
        // Recursion::) TC: O(2^(n+m)) 
        //return solveRec(s.length(),t.length(),s,t);

        // Lets Memoise it fast:)
        // Arrays.stream(memo).forEach(a->Arrays.fill(a,-1));
        // return solveMemo(s.length(),t.length(),s,t);
        return solveTab(s.length(),t.length(),s,t);
        
    }
    public static int solveRec(int n,int m,String s, String t){
        // Wheneve we have to retrun ways count:
        // return should be 0/1
        //Base Case::
        if(m==0) return 1;
        if(n==0) return 0;
        // if both are same:: Case -1:
        // 2 choices -- either take and leave:
        if(s.charAt(n-1)==t.charAt(m-1)){
            //  take  and leave choice :: no. of ways that why add the result::
            return solveRec(n-1,m-1,s,t) + solveRec(n-1,m,s,t);
        }else{
            // leave it since no choice available::
            return solveRec(n-1,m,s,t);
        }
    }
    public static int solveMemo(int n,int m,String s, String t){
        // Wheneve we have to retrun ways count:
        // return should be 0/1
        //Base Case::
        if(m==0) return 1;
        if(n==0) return 0;

        if(memo[n][m]!=-1){
            return memo[n][m];
        }
        // if both are same:: Case -1:
        // 2 choices -- either take and leave:
        if(s.charAt(n-1)==t.charAt(m-1)){
            //  take  and leave choice :: no. of ways that why add the result::
            return memo[n][m]=solveMemo(n-1,m-1,s,t) + solveMemo(n-1,m,s,t);
        }else{
            // leave it since no choice available::
            return memo[n][m]=solveMemo(n-1,m,s,t);
        }
    }
    public static int solveTab(int n,int m,String s, String t){
        //Tabulation::
        int tab[][] = new int[n+1][m+1];
        //initlisation::
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(j==0) tab[i][j]=1;
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    tab[i][j] = tab[i-1][j-1] +tab[i-1][j];
                }else{
                    tab[i][j] =tab[i-1][j];
                }
            }
        }
        return tab[n][m];
    }
}
