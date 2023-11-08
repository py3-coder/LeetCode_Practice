class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        //
        // Solved using Sliding Windows::
        return solve(nums,k)-solve(nums,k-1);
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