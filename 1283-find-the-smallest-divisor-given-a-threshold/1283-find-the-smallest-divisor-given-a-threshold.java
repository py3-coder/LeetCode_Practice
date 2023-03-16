class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max =0;
        for(int val :nums){
            max = Math.max(val,max);
        }
        if(nums.length==threshold){
            return max;
        }
        int res =0;
        int start=1;
        int end = max;
        while(start<=end){
            int mid = start +(end-start)/2;
            if(isPossible(nums,threshold,mid)==true){
                res = mid;
                end = mid-1;
            }else {
                start = mid+1;
            }
        }
        return res;
    }
    public static boolean isPossible(int[] arr, int threshold,int divisor){
        int newthreshold =0;
        for(int i=0;i<arr.length;i++){
            newthreshold +=(int)Math.ceil(arr[i]*1.0/divisor);
        }
        return newthreshold<=threshold;
        
    }
}