class Solution {
    // LCS Problem::
    public int minDistance(String word1, String word2) {
        return solveTabLCS(word1,word2);
        
    }
    public static int solveTabLCS(String S1,String S2){
        // Tabulation::
        int n=S1.length();
        int m=S2.length();
        int tab[][] = new int[n+1][m+1];
        //Initlisation:: Default Value ->0:
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(S1.charAt(i-1)==S2.charAt(j-1)){
                    tab[i][j] = 1+tab[i-1][j-1];
                }else{
                    tab[i][j] =Math.max(tab[i][j-1],tab[i-1][j]);
                }
            }
        }
        int del =S1.length()-tab[n][m];
        int ins= S2.length()-tab[n][m];
        return del+ins;
    }
}