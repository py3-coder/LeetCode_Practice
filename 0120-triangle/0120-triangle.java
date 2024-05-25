class Solution {
    int[][] memo;
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        memo = new int[n][n];
        Arrays.stream(memo).forEach(a-> Arrays.fill(a,-1));
        //return solveRec(0,0,triangle);
        
        return solveTab(triangle);
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
        return memo[i][j]=tri.get(j).get(i)+Math.min(curr,next);
    }
    
    public int solveTab(List<List<Integer>> triangle) {
        // create  table by copying the input triangle
        List<List<Integer>> table = new ArrayList<>();
        for (List<Integer> row: triangle) 
            table.add(new ArrayList<>(row));

        
        for (int row = triangle.size() - 2; row >= 0; row--) {
            for (int col = 0; col < triangle.get(row).size(); col++) {
                // either go to [row + 1, col] or [row + 1, col + 1]
                int remain = Math.min(table.get(row + 1).get(col),
                                      table.get(row + 1).get(col + 1));
                

                table.get(row).set(col, triangle.get(row).get(col) + remain);
            }
        }
        return table.get(0).get(0);
    }
}