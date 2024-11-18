class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        // Sweep Line ALgo :-
         int n = nums.length;
        
        int[] line = new int[n+1];
        
        for(int[] query : queries){
            line[query[0]]++;
            line[query[1]+1]--;
        }
        
        if (line[0] < nums[0]) {
            return false;
        }
        
        for(int i=1;i<n;i++){
            line[i] = line[i]+line[i-1];
            
            if(line[i]<nums[i]){
                return false;
            }
        }
        return true;
    }
}