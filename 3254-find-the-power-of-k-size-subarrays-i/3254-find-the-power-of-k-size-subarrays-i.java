class Solution {
    public int[] resultsArray(int[] nums, int k) {
        // int n = nums.length;
        // int start =0;
        // int end = start+k-1;
        // int[] res = new int[n-k+1]; 
        // while(end<nums.length && start<n-k+1){
        //     int sol = findMaxAndCheckSorted(nums, start , end);
        //     res[start]=sol;
        //     start++;
        //     end++;
        // }
        // return res;
        
        
        int n = nums.length;
        int[] p = new int[n];
        for (int i = 1; i < n; i++)
        {
            p[i] = p[i - 1] + ((nums[i] == (nums[i - 1] + 1)) ? 1 : 0);
        }

        var ans = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++)  
        {
            if (p[i + k - 1] == (p[i] + k - 1))
            {
                ans[i] = (nums[i + k - 1]);
            }
            else
            {
                ans[i] = -1;
            }
        }
        return ans;
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