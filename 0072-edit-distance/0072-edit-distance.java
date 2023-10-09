class Solution {
    static int[][]  memo = new int[501][501];
    public int minDistance(String word1, String word2) {
        // Recursion:: TLE ::
        //return solveRec(word1.length(),word2.length(),word1,word2);
        Arrays.stream(memo).forEach(a->Arrays.fill(a,-1));
        return solveMemo(word1.length(),word2.length(),word1,word2);

        
    }
    public static int solveRec(int n,int m,String word1,String word2){
        //Base::
        if(n==0 && m==0) return 0;
        // when word1 finishes and due in word2 means that we need to insert in word1 
        if(n==0) return m;
        // when word2 finishes and due in word1 means we got the match part 
        //to make equal need to delete the left one::
        if(m==0) return n;
        // if both char are equal we don't need do any just decrease i and j::
        if(word1.charAt(n-1)==word2.charAt(m-1)){
            return solveRec(n-1,m-1,word1,word2);
        }else{
            // 3 choices: insert / delete / replace 
            // try all and take min of all:
            int insert = 1+solveRec(n,m-1,word1,word2);
            int delete =1+solveRec(n-1,m,word1,word2);
            int replace =1+solveRec(n-1,m-1,word1,word2);

            return Math.min(insert,Math.min(delete,replace));
        }

    }
    public static int solveMemo(int n,int m,String word1,String word2){
        //Base::
        if(n==0 && m==0) return 0;
        // when word1 finishes and due in word2 means that we need to insert in word1 
        if(n==0) return m;
        // when word2 finishes and due in word1 means we got the match part 
        //to make equal need to delete the left one::
        if(m==0) return n;

        if(memo[n][m]!=-1){
            return memo[n][m];
        }
        // if both char are equal we don't need do any just decrease i and j::
        if(word1.charAt(n-1)==word2.charAt(m-1)){
            return memo[n][m]=solveMemo(n-1,m-1,word1,word2);
        }else{
            // 3 choices: insert / delete / replace 
            // try all and take min of all:
            int insert = 1+solveMemo(n,m-1,word1,word2);
            int delete =1+solveMemo(n-1,m,word1,word2);
            int replace =1+solveMemo(n-1,m-1,word1,word2);

            return memo[n][m]=Math.min(insert,Math.min(delete,replace));
        }

    }
}