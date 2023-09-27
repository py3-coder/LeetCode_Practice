class Solution {
    public int findShortestSubArray(int[] nums) {
        //Broute Force :: 
        // TC : O(n)+O(n)+O(n)
        //Sc: O(n)
        
        //Lets try to optimise::
        //TC : O(n)
        //SC : O(n)+O(k)  where k<n
        HashMap<Integer,Integer> fqmap = new HashMap<>(), firstindex =new HashMap<>();
        int degree=0;
        int res=Integer.MAX_VALUE;
        
        for(int i=0;i<nums.length;i++){
            firstindex.putIfAbsent(nums[i],i);
            fqmap.put(nums[i],fqmap.getOrDefault(nums[i],0)+1);
            if(fqmap.get(nums[i])>degree){
                degree =fqmap.get(nums[i]);
                res =i-firstindex.get(nums[i])+1;
            }else if(fqmap.get(nums[i])==degree){
                res =Math.min(res,i-firstindex.get(nums[i])+1);
            }
        }
        return res;
    }
}