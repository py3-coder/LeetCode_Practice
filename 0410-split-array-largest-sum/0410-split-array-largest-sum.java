class Solution {
    public int splitArray(int[] nums, int k) {
      int low =Integer.MIN_VALUE;
      int high =0;
      for(int ele:nums){
        low=Math.max(low,ele);
        high+=ele;
       }
       while(low<=high){
           int mid =low+(high-low)/2;
           int count =checkCounter(nums,mid);
           if(count<=k){
               high=mid-1;
           }else{
               low=mid+1;
           }
       }
       return low;
    }
    public static int checkCounter(int nums[],int sum){
        int cnt=1;
        int currsum=nums[0];
        for(int i=1;i<nums.length;i++){
            if(currsum+nums[i]<=sum){
                currsum+=nums[i];
            }else{
                currsum=nums[i];
                cnt++;
            }
        }
        return cnt;
    }
}