class Solution {
    static int memo[][] = new int[501][501];
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        //LCS ::
        //return solveRec(nums1,nums2,nums1.length,nums2.length);
        Arrays.stream(memo).forEach(a->Arrays.fill(a,-1));
        return solveMemo(nums1,nums2,nums1.length,nums2.length);

    }
    public static int solveRec(int[] nums1,int[] nums2,int n,int m){
        //base case::
        if(n==0 || m==0) return 0;

        if(nums1[n-1]==nums2[m-1]){
            return 1+solveRec(nums1,nums2,n-1,m-1);
        }else{
            return Math.max(solveRec(nums1,nums2,n,m-1),solveRec(nums1,nums2,n-1,m));
        }
    }
    public static int solveMemo(int[] nums1,int[] nums2,int n,int m){
        //base case::
        if(n==0 || m==0) return 0;
        if(memo[n][m]!=-1){
            return memo[n][m];
        }
        if(nums1[n-1]==nums2[m-1]){
            return memo[n][m]= 1+solveMemo(nums1,nums2,n-1,m-1);
        }else{
            return memo[n][m]=Math.max(solveMemo(nums1,nums2,n,m-1),solveMemo(nums1,nums2,n-1,m));
        }
    }
}