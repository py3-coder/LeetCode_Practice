class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int count=0,start=0,odd=0;
        int res=0;
        for(int end=0;end<nums.length;end++){
            if(nums[end]%2!=0) {
                odd++;
                count=0;
            }
            while(odd==k){
                if(nums[start++]%2!=0) odd--;
                count++;
            }
            res+=count;
        }
        return res;
    }
}