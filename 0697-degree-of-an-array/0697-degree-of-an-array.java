class Solution {
    public int findShortestSubArray(int[] nums) {
        //Broute Force :: 
        // TC : O(n)+O(n)+O(n)
        //Sc: O(n)
        //Aproch for this:: Just save the freq in first go , next go find the ele and it frq whose maximum,
        // In third loop check the first and last index of ele---: last-first+1 == length that minimum it can h
        // hold with degree freq..
        
        
        //Lets try to optimise::
        //Approch  :: length is what here --> first index of ele whose fq is max os we capture it first index:
        // we know also store the frequecy so if we found some else have maxi now wo can switch to that ele::
        // length ---
        // if degree is same but to length can grater to bound this we take min in those case where degree re
        // remain same::
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