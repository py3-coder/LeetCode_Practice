class Solution {
    public boolean isSubsequence(String s, String t) {
        // if (s.length() == 0) return true;
        // int indexS = 0, indexT = 0;
        // while (indexT < t.length()) {
        //     if (t.charAt(indexT) == s.charAt(indexS)) {
        //         indexS++;
        //         if (indexS == s.length()) return true;
        //     }
        //     indexT++;
        // }
        // return false;

        //DP:)
        return solveTabLCS(s,t);
    }
    // DP Approch ::
    // Apply LCS on both String and check if length of s==lcs if yess true/false:

    public static boolean solveTabLCS(String s,String t){
        //Tabulation::)
        int n=s.length();
        int m=t.length();

        int tab[][] = new int[n+1][m+1];
        //Initlisation:
        //by default 0
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    tab[i][j] =1+tab[i-1][j-1];
                }else{
                    tab[i][j] =Math.max(tab[i-1][j],tab[i][j-1]);
                }
            }
        }
        return tab[n][m]==s.length();
    }
}