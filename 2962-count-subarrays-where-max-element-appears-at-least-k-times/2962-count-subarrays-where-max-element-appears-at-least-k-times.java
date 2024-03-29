class Solution {
    //Slide :::
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int maxi=0;
        for(int ele:nums){
            maxi=Math.max(ele,maxi);
        }
        int start=0,end=0,cnt=0;
        long ans=0;
        
        while(end<n){
            if(nums[end]==maxi){
                cnt++;
            }
            if(cnt>=k){
                while(cnt>=k){
                    ans+=n-end;
                    if(nums[start]==maxi){
                        cnt--;
                    }
                    start++;
                }
            }
            end++;
        }
        return ans;
    }
}
