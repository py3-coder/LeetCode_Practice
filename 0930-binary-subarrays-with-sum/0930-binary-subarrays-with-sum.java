class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        
        // Solved using Sliding Windows :: 
        // EXACT 3 == almost(3)-almost(2)
        return solve(nums,goal)-solve(nums,goal-1);
        
    }
    public static int solve(int[] arr,int k){
        if(k<0) return 0;
        int n=arr.length;
        int start=0,end=0;
        int count1=0;
        int res =0;
        while(end<n){
            if(arr[end]==1) count1++;
            while(count1>k){
                if(arr[start]==1) count1--;
                start++;
            }
            res+=end-start+1;
            end++;
        }
        return res;
    }
}