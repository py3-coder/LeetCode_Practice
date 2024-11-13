class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
       
        return findCountTarget(nums,upper+1)-findCountTarget(nums,lower);
    }
    
    public long findCountTarget(int[] nums , int target){
        long cnt=0;
        int start = 0;
        int end = nums.length-1;
        
        while(start<=end){
            if(nums[start]+nums[end]<target){
                cnt += end-start;
                start++;
            }else{
               end--;
            }
        }
        return cnt;
    }
    
   
}