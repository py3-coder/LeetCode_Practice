class Solution {
    static int[][] memo;
    public int longestCommonSubsequence(String s1, String s2) {
        int n = s1.length(),m=s2.length();
        memo  = new int[n+1][m+1];
        Arrays.stream(memo).forEach(a->Arrays.fill(a,-1));
        //return solveRec(s1,s2,n,m);
        
        return solveTab(s1,s2,n,m);
    }
    public int solveRec(String s1,String s2,int a,int b){
        //base case ::-
        if(a==0 || b==0) return 0;
        
        if(memo[a][b]!=-1){
            return memo[a][b];
        }
        if(s1.charAt(a-1) == s2.charAt(b-1)){
            return memo[a][b]= 1+ solveRec(s1,s2,a-1,b-1);
        }else{
            return memo[a][b]= Math.max(solveRec(s1,s2,a-1,b),solveRec(s1,s2,a,b-1));
        }
    }
    public int solveTab(String s1,String s2,int n,int m){
        int[][] tab = new int[n+1][m+1];
        
        //base case ::
        
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(s1.charAt(i-1)== s2.charAt(j-1)){
                    tab[i][j] = 1+tab[i-1][j-1];
                }else{
                    tab[i][j] = Math.max(tab[i][j-1],tab[i-1][j]);
                }
            }
        }
        return tab[n][m];
    }
    
    public int solveOpt(String s1,String s2,int n,int m){
        int[] curr = new int[m+1];
        int[] prev = new int[m+1];
        
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(s1.charAt(i-1)== s2.charAt(j-1)){
                    curr[j] = 1+prev[j-1];
                }else{
                    curr[j] = Math.max(curr[j-1],prev[j]);
                }
            }
            
        }
        return curr[m];
    }
}