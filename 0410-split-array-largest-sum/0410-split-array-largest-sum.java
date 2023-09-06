class Solution {
    public int splitArray(int[] nums, int k) {
        int low =Integer.MIN_VALUE;
        int high =0;
        for(int val :nums){
            low =Math.max(low,val);
            high+=val;
        }
        while(low<=high){
            int mid =low+(high-low)/2;
            int count = SumCounter(nums,mid);
            if(count<=k){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
    public static int SumCounter(int[] arr, int sum){
        int count=1;
        int last=0;
        for(int i=0;i<arr.length;i++){
            if(last+arr[i]<=sum){
                last+=arr[i];
            }else{
               count++;
                last=arr[i];
            }
        }
        return count;
    }
}