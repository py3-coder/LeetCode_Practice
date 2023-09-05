class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        //edge case ::
        if(nums.length-1==threshold){
            return threshold;
        }
        int low=1;
        int high=Integer.MIN_VALUE;
        for(int val:nums){
            high=Math.max(val,high);
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            int ans=check(mid,nums);
            if(ans<=threshold){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
    public static int check(int mid,int[] arr){
        int ans=0;
        for(int val:arr){
            ans+=Math.ceil((double)(val)/(double)(mid));
        }
        return ans;
    }
}