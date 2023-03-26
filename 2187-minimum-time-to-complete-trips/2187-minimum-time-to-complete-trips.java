class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long res = -1;
        long start = 1;
        long end = 100000000000001L;
        while(start<=end){
            long mid = start +(end-start)/2;
            if(isPossible(time , mid , totalTrips)==true){
                res = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return res;
    }
    public static boolean isPossible(int[] arr,long mid , int totalTrips){
        long trip=0;
        for(int val : arr){
            trip  += mid/val;
        }
        return trip>=totalTrips;
    }
}