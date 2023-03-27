class Solution {
    public long repairCars(int[] ranks, int cars) {
        long start =1;
        long end =1L* cars *cars *100;
        long res=0;
        while(start<=end){
            long mid = start +(end-start)/2;
            if(isPossible(mid , ranks , cars)==true){
                res = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return res;
    }
    public static boolean isPossible(long time ,int[] ranks ,int cars){
        long count =0;
        for(int i=0;i<ranks.length;i++){
            count +=(int)Math.floor(Math.sqrt(time/ranks[i]));
             if(count>=cars)break;
        }
        return count>=cars;
    }
}