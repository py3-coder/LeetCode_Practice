class Solution {
    public int minPairSum(int[] nums) {
        //TC :O(nlogn) +O(n)
        // SC :O(1)
        // Arrays.sort(nums);
        // int maxi=0;
        // int left=0;
        // int right=nums.length-1;
        // while(left<=right){
        //     maxi =Math.max(nums[left]+nums[right],maxi);
        //     left++;
        //     right--;
        // }
        // return maxi;
        
        //TC : O(Math.max(k,max)) 
        //SC: O(1)
        
        int maxi=0;
        int mini=Integer.MAX_VALUE;
        int[] cnt=new int[100001];
        for(int i=0;i<nums.length;i++){
            cnt[nums[i]]++;
            maxi =Math.max(nums[i],maxi);
            mini =Math.min(nums[i],mini);
        }
        int l=mini;
        int h=maxi;
        maxi=0;
        while(l<=h){
            if(cnt[l]==0) l++;
            else if(cnt[h]==0) h--;
            else{
                maxi =Math.max(h+l,maxi);
                cnt[l]--;
                cnt[h]--;
            }
        }
        return maxi;
    }
}