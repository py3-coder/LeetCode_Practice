class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum=0;
        for(int val:nums){
            sum+=val;
        }
        return (n*(n+1)/2)-sum;
    }
}