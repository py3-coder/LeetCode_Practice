class Solution {
    public int findDuplicate(int[] nums) {
        // HashMap<Integer, Integer> map = new HashMap<>();
        // for(int val:nums){
        //     map.put(val, map.getOrDefault(val,0)+1);
        // }
        // for (Map.Entry<Integer,Integer> entry : map.entrySet()){
        //     if(entry.getValue()>=2){
        //         return entry.getKey();
        //     }
        // }
        // return 0;
        
        //TC : O(n)+O(n)
        //SC: O(n)
        
        
        //Lets Apply LinkList Connect of Cycle ::
        if(nums.length>1){
            int slow =nums[0];
            int fast=nums[nums[0]];
            while(fast!=slow){
                slow =nums[slow];
                fast=nums[nums[fast]];
            }
            fast=0;
            while(fast!=slow){
                fast =nums[fast];
                slow=nums[slow];
            }
            return slow;
        }
        return -1;
        
        
        //TC : O(n)::
        //SC : O(1)::
    }
}