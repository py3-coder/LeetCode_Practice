class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        
        return solveTab(str1,str2,n,m);
        
    }
    public String solveTab(String s1,String s2,int n,int m){
        //
        int[][] tab = new int[n+1][m+1];
        
        
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    tab[i][j] = 1+tab[i-1][j-1];
                }else{
                    tab[i][j] = Math.max(tab[i-1][j], tab[i][j-1]);
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        int i =n,j=m;
        
        while(i>0 &&j>0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                sb.append(s1.charAt(i-1));
                i--;
                j--;
            }else{
                if(tab[i][j-1]>tab[i-1][j]){
                    sb.append(s2.charAt(j-1));
                    j--;
                }else{
                    sb.append(s1.charAt(i-1));
                    i--;
                }
            }
        }
        while(i>0){
            sb.append(s1.charAt(i-1));
            i--;
        }
        while(j>0){
            sb.append(s2.charAt(j-1));
            j--;
        }
        
        
        return (sb.reverse()).toString();
    }
}