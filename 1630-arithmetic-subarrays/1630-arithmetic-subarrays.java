class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        //Broute Force ::
        // Sort every query :) and check the diff :)
        // O(m)*(O(klogk)+O(k))  -- K is size of query array length 
        
        
        // Optimized approch :):
        //without sorting :):: since sorting take O(klogk) time lets try to reduce it:)
        List<Boolean> res = new ArrayList<>();
        for(int i=0;i<l.length;i++){
            res.add(solve(nums,l[i],r[i]));
        }
        return res;
        
        
    }
    public static boolean solve(int[] nums,int start,int end){
        if((end-start)<2) return true;
        Set<Integer> set = new HashSet<>();
        int maxi=Integer.MIN_VALUE;
        int mini=Integer.MAX_VALUE;
        
        for(int i=start;i<end+1 ;i++){
            maxi =Math.max(nums[i],maxi);
            mini =Math.min(nums[i],mini);
            set.add(nums[i]);
        }
        
        //Lets check the range is evenly spaced or not?
        if((maxi-mini)%(end-start)!=0){
            return false;
        }
        int diff =(maxi-mini)/(end-start);
        int curr =mini+diff;
        while(curr<maxi){
            if(!set.contains(curr)){
                return false;
            }
            curr+=diff;
        }
        return true;
    }
}