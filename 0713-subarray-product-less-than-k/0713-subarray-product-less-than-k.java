class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        //Broute Force : 
        //TC : O(n^2)
        //SC : O(1)

        //Lets Try Sliding Window:::
        int n =nums.length;
        long prod=1;
        int start=0;
        int end=0;
        int count=0;
        while(end<n){
            prod*=nums[end];
            while(prod>=k && start<=end){
                prod/=nums[start];
                start++;
            }
            count+=end-start+1;
            end++;
        }
        return count;
    }
}