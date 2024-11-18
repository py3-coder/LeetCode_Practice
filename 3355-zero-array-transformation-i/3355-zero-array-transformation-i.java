class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        // Sweep Line ALgo :-
        int n = nums.length;
        
        int[] line = new int[n+1];
        
        for(int[] query : queries){
            line[query[0]]--;
            line[query[1]+1]++;
        }
        
        for(int i=1;i<n;i++){
            line[i] = line[i]+line[i-1];
        }
            
        for(int i=0;i<n;i++){
            nums[i] = line[i]+nums[i];
            if(nums[i]<0){
                nums[i]=0;
            }
            if(nums[i]>0){
                return false;
            }
        }
        return true;
    }
}