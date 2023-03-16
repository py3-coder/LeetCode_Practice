class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=0;
        for(int val : piles){
            max = Math.max(val,max);
        }
        if(piles.length==h){
            return max;
        }
        int start =0;
        int end = max;
        int res = 0;
        while(start<=end){
            int mid = start +(end-start)/2;
            if(isPossible(piles,h,mid)==true){
                res = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return res;
    }
    public static boolean isPossible(int[] arr,int h,int mid){
        int time =0;
        for(int i=0;i<arr.length;i++){
            time += Math.ceil(arr[i]*1.0/mid);//if we do arr[i]/mid 7/3 = 2 but we want 7/3 = 3 that why 1.0
        }
        return time<=h;
    }
}