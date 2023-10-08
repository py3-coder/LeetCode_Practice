class Solution {
    public String longestPalindrome(String s) {
        String rev="";
        for(char ch:s.toCharArray()){
            rev=ch+rev;
        }
        return solveTabLCS(s,rev);
        
    }
    public static String  solveTabLCS(String s1,String s2){
        // Tabulation::
        String ans="";
        int n=s1.length();
        int res=0;
        int tab[][] = new int[n+1][n+1];
        //base - intilization by default :0
        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    tab[i][j] =1+tab[i-1][j-1];
                    // Important ::
                    if(tab[i][j]>res){
                        String temp = s1.substring(i-tab[i][j],i);
                        StringBuilder sb = new StringBuilder(temp);
                        sb.reverse();
                        String reversed =sb.toString();
                        if(temp.equals(reversed)){
                            ans=temp;
                            res=tab[i][j];
                        }
                    }
                    // 
                }else{
                    tab[i][j] =0;
                }
            }
        }
        return ans;
    }
}