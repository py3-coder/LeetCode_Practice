class Solution {
    public int minOperations(int[] nums, int x) {
        // Lets Use Sliding Window , Intution is Simple ::
        // Maximum Subarray Sum of TotalSum-X::
        
        
        //edge case ::
        int sum=0;
        for(int ele:nums) sum+=ele;
        int target =sum-x;
        //System.out.println(target);
        //if(target==0) return nums.length;
        int start=0,end=0,res=-1;
        int currsum=0;
        while(end<nums.length){
            currsum+=nums[end];
            while(currsum>target && start<=end){
                    currsum-=nums[start];
                    start++;
                }
           if(currsum==target){
               res=Math.max(res,end-start+1);
           }
           end++;
        }
        return res == -1 ? -1 : nums.length - res;
    }
}

	