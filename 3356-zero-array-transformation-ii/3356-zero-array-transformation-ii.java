class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
         // Sweep Line ALgo :-
        int start = 0;
        int end = queries.length;
        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isPossible(nums, queries, mid)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }
    
    public boolean isPossible(int[] nums, int[][] queries,int k){
        int n = nums.length;
        
        int[] line = new int[n+1];
        
        for(int idx = 0; idx < k; idx++){
            line[queries[idx][0]] += queries[idx][2];
            line[queries[idx][1] + 1] -= queries[idx][2];
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