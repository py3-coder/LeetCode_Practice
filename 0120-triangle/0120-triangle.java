class Solution {
    int[][] memo;
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        memo = new int[n][n];
        Arrays.stream(memo).forEach(a-> Arrays.fill(a,-1));
        return solveRec(0,0,triangle);
    }
    public int solveRec(int i ,int j,List<List<Integer>> tri){
        if(j == tri.size()){
            return 0;
        }
        if(memo[i][j]!=-1){
            return memo[i][j];
        }  
        return memo[i][j]=tri.get(j).get(i)+Math.min(solveRec(i,j+1,tri),solveRec(i+1,j+1,tri));
    }
    
}