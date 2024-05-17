class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        String rev ="";
        for(int i=0;i<n;i++){
            rev =s.charAt(i)+rev;
        }
        System.out.println(rev);
        return solveOpt(s,rev,n,n);
        
    }
    // Optimised code for LCS
    public static int solveOpt(String s1,String s2,int n,int m){
        int[] curr = new int[m+1];
        int[] prev = new int[m+1];
   
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    curr[j] = 1+prev[j-1];
                }else{
                    curr[j] = Math.max(curr[j-1],prev[j]);
                }
            }
            for(int k=0;k<m+1;k++){
                prev[k] = curr[k];
            }
        }
        return curr[m];
    }
}