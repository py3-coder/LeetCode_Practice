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
        int curr = Integer.MAX_VALUE,next = Integer.MAX_VALUE;
        curr =tri.get(j).get(i) + solveRec(i,j+1,tri);
        next = tri.get(j).get(i) + solveRec(i+1,j+1,tri);   
        return memo[i][j]=Math.min(curr,next);
    }
    
}