class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(p -> p[0]));
        int maxW=0;
        for(int i=1;i<points.length;i++){
            maxW =Math.max(points[i][0]-points[i-1][0],maxW);
        }
        return maxW;
    }
}