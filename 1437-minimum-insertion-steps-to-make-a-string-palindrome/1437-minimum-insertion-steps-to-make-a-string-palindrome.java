class Solution {
    public int minInsertions(String s) {
        String rev="";
        for(char ch: s.toCharArray()){
            rev =ch+rev;
        }
        int n=s.length();
        return solveTabLCS(s,rev,n,n);
        
    }
    public static int solveTabLCS(String X,String Y,int n,int m){
        // Tabulation::
        
        int tab[][] = new int[n+1][m+1];
        //Base case by default handle::
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(X.charAt(i-1)==Y.charAt(j-1)){
                    tab[i][j]=1+tab[i-1][j-1];
                }else{
                    tab[i][j]= Math.max(tab[i-1][j],tab[i][j-1]);
                }
            }
        }
        return X.length()-tab[n][m];
    }
}