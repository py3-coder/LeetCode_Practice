class Solution {
    public int shipWithinDays(int[] weights, int days) {
        //Broute Force Approch :: Apply Linear Search:)
        // TC : O(log)*O(n) ~ O(nlogn)
        
        int low =Integer.MIN_VALUE;
        int high=0;
        for(int ele:weights){
            low =Math.max(low,ele);
            high+=ele;
        }
        while(low<=high){
            int mid =low+(high-low)/2;
            if(isPossible(weights,mid,days)){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
    public static boolean isPossible(int[] nums,int capacity,int days){
        int cntday=1;
        int weight=nums[0];
        for(int i=1;i<nums.length;i++){
            if(weight+nums[i]<=capacity){
                weight+=nums[i];
            }else{
                cntday++;
                weight=nums[i];
            }
        }
        return (cntday<=days)?true:false;
    }
}