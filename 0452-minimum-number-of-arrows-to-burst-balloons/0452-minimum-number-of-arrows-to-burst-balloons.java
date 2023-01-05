class Solution {
    public int findMinArrowShots(int[][] points) {
       Arrays.sort(points,(a,b)->Integer.compare(a[1],b[1]));
        int res =1;
        int prev =0;
        for(int i=1;i<points.length;i++){
            if(points[i][0]>points[prev][1]){
                res++;
                prev =i;
            }
        }
        return res;
    }
}