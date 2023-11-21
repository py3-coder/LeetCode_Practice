class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n =intervals.length;
        Arrays.sort(intervals,(a,b)->(a[1]-b[1]));
        int cnt=0;
        int prevEnd=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int start =intervals[i][0];
            int end=intervals[i][1];
            if(start>=prevEnd){
                prevEnd=end;
            }else{
                cnt++;
            }
        }
        return cnt;
    }
}