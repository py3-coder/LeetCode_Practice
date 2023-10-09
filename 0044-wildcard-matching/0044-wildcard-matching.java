class Solution {
    static int[][] memo= new int[2001][2001];
    public boolean isMatch(String s, String p) {
        //1. Recursions:
       // return solveRec(s.length(),p.length(),s,p);
       Arrays.stream(memo).forEach(a->Arrays.fill(a,-1));
       return solveMemo(s.length(),p.length(),s,p)==1?true:false;

    }
    public static boolean solveRec(int n,int m,String s , String p){
        //Base ::
        if(n==0 && m==0) return true;
        if(n!=0 && m==0) return false;
        if(n==0 && m!=0){
            return checkAllStar(p,m);
        }

        //choices:
        if(s.charAt(n-1)==p.charAt(m-1) || (p.charAt(m-1)=='?')){
            return solveRec(n-1,m-1,s,p);
        }
        else if(p.charAt(m-1)=='*'){
            return solveRec(n-1,m,s,p) || solveRec(n,m-1,s,p);
        }else{
            return false;
        }
    }
    public static boolean checkAllStar(String p,int m){
        for(int i=0;i<m;i++){
            if(p.charAt(i)!='*'){
                return false;
            }
        }
        return true;
    }
    public static int solveMemo(int n,int m,String s , String p){
        //Base ::
        if(n==0 && m==0) return 1;
        if(n!=0 && m==0) return 0;
        if(n==0 && m!=0){
            return checkAllStar(p,m)==true?1:0;
        }

        if(memo[n][m]!=-1){
            return memo[n][m];
        }
        //choices:
        if(s.charAt(n-1)==p.charAt(m-1) || (p.charAt(m-1)=='?')){
            return memo[n][m]=solveMemo(n-1,m-1,s,p);
        }
        else if(p.charAt(m-1)=='*'){
            return memo[n][m]=Math.max(solveMemo(n-1,m,s,p),solveMemo(n,m-1,s,p));
        }else{
            return 0;
        }
    }

}