class Solution {
    public int minSizeSubarray(int[] nums, int target) {
        //Lets Play with Sliding Window :::
        int sum=0;
        for(int ele:nums){
            sum+=ele;
        }
        int mul =target/sum;
        target =target%sum;
        int recArr[] = new int[nums.length*2];
        for(int i=0;i<nums.length;i++){
            recArr[i] =nums[i];
            recArr[nums.length+i] =nums[i];
        }
        int ans=Integer.MAX_VALUE;
        sum=0;
        int start=0,end=0;
        while(end<recArr.length){
            sum+=recArr[end];
            while(sum>target && start<=end){
                sum-=recArr[start];
                start++;
            }
            if(sum==target){
                ans=Math.min(ans,end-start+1);
            }
            end++;
        }
        return ans==Integer.MAX_VALUE?-1:ans+(mul*nums.length);
        
    }
}