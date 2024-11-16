class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int start =0;
        int end = start+k-1;
        int[] res = new int[n-k+1]; 
        while(end<nums.length && start<n-k+1){
            int sol = findMaxAndCheckSorted(nums, start , end);
            res[start]=sol;
            start++;
            end++;
            
        }
        return res;
    }
    
    public int findMaxAndCheckSorted(int[] arr ,int start , int end){
        for(int i=start;i<end;i++){
            if(arr[i]+1!=arr[i+1]){
                return -1;
            }
        }
        return arr[end];
    }
}