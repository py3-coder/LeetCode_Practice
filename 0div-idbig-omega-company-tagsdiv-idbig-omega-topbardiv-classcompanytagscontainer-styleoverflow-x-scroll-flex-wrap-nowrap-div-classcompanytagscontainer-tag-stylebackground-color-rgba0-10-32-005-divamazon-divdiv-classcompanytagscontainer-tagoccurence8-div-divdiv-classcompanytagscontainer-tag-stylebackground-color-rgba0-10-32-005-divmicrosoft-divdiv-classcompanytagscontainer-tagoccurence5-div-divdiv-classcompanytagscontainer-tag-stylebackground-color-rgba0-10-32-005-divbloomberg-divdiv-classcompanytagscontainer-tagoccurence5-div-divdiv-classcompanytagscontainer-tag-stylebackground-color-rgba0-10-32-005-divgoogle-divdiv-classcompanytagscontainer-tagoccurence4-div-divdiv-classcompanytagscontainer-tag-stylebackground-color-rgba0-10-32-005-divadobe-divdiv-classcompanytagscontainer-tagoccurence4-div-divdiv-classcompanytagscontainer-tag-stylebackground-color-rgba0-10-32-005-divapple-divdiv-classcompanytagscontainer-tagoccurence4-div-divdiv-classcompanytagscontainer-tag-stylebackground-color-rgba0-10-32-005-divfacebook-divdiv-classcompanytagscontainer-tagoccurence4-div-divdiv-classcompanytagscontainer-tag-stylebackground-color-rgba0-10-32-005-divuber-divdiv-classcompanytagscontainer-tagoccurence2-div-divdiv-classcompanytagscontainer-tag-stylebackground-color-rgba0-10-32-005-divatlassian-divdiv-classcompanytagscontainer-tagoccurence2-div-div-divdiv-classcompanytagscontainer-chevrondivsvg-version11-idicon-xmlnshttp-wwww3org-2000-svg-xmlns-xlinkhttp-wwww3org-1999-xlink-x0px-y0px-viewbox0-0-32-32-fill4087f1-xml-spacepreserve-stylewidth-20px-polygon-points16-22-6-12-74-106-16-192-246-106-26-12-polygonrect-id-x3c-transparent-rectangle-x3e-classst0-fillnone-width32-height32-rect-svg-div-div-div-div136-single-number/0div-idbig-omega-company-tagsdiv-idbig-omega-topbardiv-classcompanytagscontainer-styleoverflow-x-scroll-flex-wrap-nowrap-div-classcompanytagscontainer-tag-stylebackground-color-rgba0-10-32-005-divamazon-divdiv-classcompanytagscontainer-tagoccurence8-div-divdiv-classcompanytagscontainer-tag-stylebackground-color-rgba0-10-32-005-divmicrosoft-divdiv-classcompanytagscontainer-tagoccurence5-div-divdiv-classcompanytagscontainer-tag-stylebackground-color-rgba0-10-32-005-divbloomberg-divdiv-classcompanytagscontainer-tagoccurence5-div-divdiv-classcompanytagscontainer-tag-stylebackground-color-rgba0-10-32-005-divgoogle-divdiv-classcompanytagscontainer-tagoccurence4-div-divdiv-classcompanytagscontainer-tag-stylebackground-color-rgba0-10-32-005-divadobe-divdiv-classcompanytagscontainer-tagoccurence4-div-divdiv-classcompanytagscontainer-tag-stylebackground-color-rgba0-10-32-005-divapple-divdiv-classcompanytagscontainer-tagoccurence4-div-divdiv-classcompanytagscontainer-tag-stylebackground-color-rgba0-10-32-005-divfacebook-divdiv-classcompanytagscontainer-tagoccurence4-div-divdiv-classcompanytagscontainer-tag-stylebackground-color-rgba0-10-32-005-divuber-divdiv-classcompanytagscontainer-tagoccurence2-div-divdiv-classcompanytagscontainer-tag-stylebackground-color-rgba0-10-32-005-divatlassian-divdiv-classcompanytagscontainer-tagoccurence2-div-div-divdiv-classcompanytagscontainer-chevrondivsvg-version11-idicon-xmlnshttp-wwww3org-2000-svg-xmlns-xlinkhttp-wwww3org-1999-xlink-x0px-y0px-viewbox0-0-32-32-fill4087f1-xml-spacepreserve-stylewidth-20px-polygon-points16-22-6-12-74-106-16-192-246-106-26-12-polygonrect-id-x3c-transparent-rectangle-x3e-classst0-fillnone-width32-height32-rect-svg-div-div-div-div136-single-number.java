class Solution {
    public int singleNumber(int[] nums) {
        //edge case 
        int n= nums.length;
        if(nums.length==1){
            return nums[0];
        }
        Arrays.sort(nums);
        // for(int i=0;i<n-1;i+=2){
        //     if(nums[i]!=nums[i+1]){
        //         return nums[i];
        //     }
        // }
        // if(nums[n-1]!=nums[n-2]){
        //     return nums[n-1];
        // }
        // return 0;
        
        //TC : O(nlogn)+O(n)
        //SC : O(1);
        
        // Lets thing for Optimise::
        int low =0;
        int high=n-1;
        while(low<high){
            int mid =low+(high-low)/2;
            if(mid%2!=0){
                mid-=1;
            }
            if(nums[mid]==nums[mid+1]){
                low=mid+2;
            }else{
                high=mid;
            }
        }
        return nums[low];
    }
}