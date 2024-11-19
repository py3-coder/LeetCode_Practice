class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        //Sliding window ::
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int start =0;
        int end =0;
        long sum=0, ans =0;
        while(end<n){  
            sum+=nums[end];
            map.put(nums[end] , map.getOrDefault(nums[end],0)+1);
            
            while(end-start+1>k){
                sum-=nums[start];
                map.put(nums[start],map.get(nums[start])-1);
                if(map.get(nums[start])==0){
                     map.remove(nums[start]);
                }
               
                start++;
            }
            
            if(end-start+1 == k && map.size()==k){
                ans = Math.max(ans,sum);
            }
            
            end++;
        }
        return ans;
    }
}