class Solution {
    public int islandPerimeter(int[][] grid) {
    Set<String> visitSet = new HashSet();
    
    for(int i=0;i<grid.length;i++){
        for(int j=0; j<grid[0].length;j++){
            if(grid[i][j]==1)
                return helper(grid, i, j, visitSet);
        }
    }
    return -1;
}

//recursive helper function
private int helper(int[][] grid, int i, int j, Set<String> visitSet){
    
    if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==0)
        return 1;
    if(visitSet.contains(i+","+j))
        return 0;
    
    visitSet.add(i+","+j);
    int perimeter = helper(grid,i-1,j,visitSet);
    perimeter+=helper(grid,i+1,j,visitSet);
    perimeter+=helper(grid,i,j-1,visitSet);
    perimeter+=helper(grid,i,j+1,visitSet);
    
    return perimeter;
}
}