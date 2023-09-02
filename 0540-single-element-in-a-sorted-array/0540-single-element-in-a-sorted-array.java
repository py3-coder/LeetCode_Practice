class Solution {
    public int singleNonDuplicate(int[] nums) {
        //Iterative Ways::
        int n = nums.length;
        // if(n==1){
        //     return nums[0];
        // }
        // for(int i=0;i<n;i++){
        //     if(i==0){
        //         if(nums[i]!=nums[i+1]){
        //             return nums[i];
        //         }
        //     }else if(i==n-1){
        //             if(nums[i]!=nums[i-1]){
        //                 return nums[i];
        //             }
        //     }else{
        //             if(nums[i]!=nums[i-1] && nums[i]!=nums[i+1]){
        //                 return nums[i];
        //             }
        //         }     
        // }
        // return -1;
        
        
        // XOR ways ::
        // a^a=0
        // a^0=a
        // int ans=0;
        // for(int i=0;i<n;i++){
        //     ans =ans^nums[i];
        // }
        // return ans;
        
        //Binary Search Way :::
        //Edge case:
        if(n==1){
            return nums[0];
        }
        if(nums[0]!=nums[1]){
            return nums[0];
        }
        if(nums[n-1]!=nums[n-2]){
            return nums[n-1];
        }
         
        int left=1;
        int right=n-2;
        while(left<=right){
            int mid =left+(right-left)/2;
            //if mid is single lets check
            if(nums[mid]!=nums[mid+1] && nums[mid]!=nums[mid-1]){
                return nums[mid];
            }
            //Left side Case ::: Left side is ok
            if((mid%2!=0 && nums[mid]==nums[mid-1]) ||(mid%2==0 && nums[mid]==nums[mid+1])){
                left=mid+1;
            }else{
                //Right side case ::Right side is ok
                right = mid-1;
            }
        }
        return -1;
    }
}