class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        return solveTabLCS(str1,str2);
    }
    public static String solveTabLCS(String str1,String str2){
        //Tabulation -- LCS 
        int n=str1.length();
        int m=str2.length();

        int tab[][] = new int[n+1][m+1];
        //Initlisation:: Base case handle by default value 0 
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    tab[i][j] =1+tab[i-1][j-1];
                }else{
                    tab[i][j] =Math.max(tab[i-1][j],tab[i][j-1]);
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        int i=n,j=m;
        while(i>0 && j>0){
            if(str1.charAt(i-1)==str2.charAt(j-1)){
                ans.append(str1.charAt(i-1));
                i--;
                j--;
            }else{
                if(tab[i][j-1]>tab[i-1][j]){
                    ans.append(str2.charAt(j-1));
                    j--;
                }else{
                    ans.append(str1.charAt(i-1));
                    i--;
                }
            }
        }
        while(i>0){
            ans.append(str1.charAt(i-1));
            i--;
        }
        while(j>0){
            ans.append(str2.charAt(j-1));
            j--;
        }

        return ans.reverse().toString();
    }
}