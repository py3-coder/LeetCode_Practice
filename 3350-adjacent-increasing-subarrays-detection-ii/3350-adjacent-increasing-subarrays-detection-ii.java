class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int start=0,end=n/2+1;
        int ans = 1;
        while(start<end){
            int mid = start+(end-start)/2;
            if(hasIncreasingSubarrays(nums,mid)==true){
                ans = Math.max(mid, ans);
                start = mid+1;
            }else{
                end = mid;
            }
        }
        return ans;
        
    }
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
       int curr = 1, prev = -1,n=nums.size();
        for(int i = 1 ; i < n ; i++){
            if(nums.get(i) > nums.get(i - 1))
                curr++;
            else{
                prev = curr;
                curr= 1;
            }
            if(curr == k && prev >= k)
                return true;
            if(curr == 2 * k)
                return true;
        }
        return false;
    }
}