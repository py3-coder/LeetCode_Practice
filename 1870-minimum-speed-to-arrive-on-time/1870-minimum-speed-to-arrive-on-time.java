class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int res =Integer.MAX_VALUE;
        int start = 1;
        int end = 10000000;
        while(start<=end){
            int mid = start +(end-start)/2;
            if(isPossible(dist ,mid ,hour)==true){
                res = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return (res == Integer.MAX_VALUE ? -1 : res);
    }
    public static boolean isPossible(int[] arr,int mid , double hour){
        double time = 0;
        for(int i=0;i<arr.length;i++){
            time = Math.ceil(time);
            time +=  (double)arr[i] /mid;
            if (time > hour) return false;
        }
        return true;
    }
}


