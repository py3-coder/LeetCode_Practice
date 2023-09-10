class Solution {
    public int longestOnes(int[] nums, int k) {
        int n=nums.length;
        int count0=0;
        int start=0;
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(nums[i]==0) count0++;
            while(count0>k){
                if(nums[start]==0) count0--;
                start++;
            }
            maxi=Math.max(maxi,i-start+1);
        }
        return maxi;
    }
}