class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        return solveTab(text1,text2);
    }
    public static int solveTab(String s,String t){
		//Tabulation::
		int n=s.length();
		int m=t.length();
		int tab[][] = new int[n+1][m+1];
		for(int i=0;i<n+1;i++){
			for(int j=0;j<m+1;j++){
				if(i==0) tab[i][j]=0;
				if(j==0) tab[i][j]=0;
			}
		}
		for(int i=1;i<n+1;i++){
			for(int j=1;j<m+1;j++){
				if(s.charAt(i-1)==t.charAt(j-1)){
					tab[i][j] =1+tab[i-1][j-1];
				}else{
					tab[i][j] =Math.max(tab[i][j-1],tab[i-1][j]);
				}
			}
		}
		return tab[n][m];
	}
}