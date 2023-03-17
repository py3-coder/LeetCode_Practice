class Solution {
    public int maximumCandies(int[] candies, long k) {
        long sum =0;
        for(int val : candies){
            sum +=val;
        }
        int res =0;
        int start =1;
        int end=(int)(sum/k);
        while(start<=end){
            int mid = start +(end-start)/2;
            if(isPossible(candies,k,mid)==true){
                res = mid;
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return res;
    }
    public static boolean isPossible(int[] arr , long k,long mid){
        long count =0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>=mid)
                count +=arr[i]/mid;
        }
        return count>=k;
    }
}