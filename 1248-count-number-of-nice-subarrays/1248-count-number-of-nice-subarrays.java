class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        //
        // Solved using Sliding Windows::
        //return solve(nums,k)-solve(nums,k-1);
        
        HashMap<Integer, Integer> mp = new HashMap<>();
        
        // Replace odd with 1 and even with 0
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) {
                nums[i] = 1;
            } else {
                nums[i] = 0;
            }
        }
        
        mp.put(0, 1);
        int sum = 0;
        int count = 0;
        for (int num : nums) {
            sum += num;
            count += mp.getOrDefault(sum - k, 0);
            mp.put(sum, mp.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }
    public static int solve(int[] arr,int k){
        int n=arr.length;
        int count=0,start=0,sum=0,end=0;
        int res=0;
        while(end<n){
            if(arr[end]%2!=0){
                sum+=1;
            }
            while(sum>k){
                if(arr[start]%2==1){
                    sum-=1;
                }
                start++;
            }
            res+=end-start+1;
            end++;
        }
        return res;
    }
}