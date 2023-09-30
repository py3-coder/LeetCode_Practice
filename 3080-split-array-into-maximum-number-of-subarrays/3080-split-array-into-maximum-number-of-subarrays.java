class Solution {
    public int maxSubarrays(int[] nums) {
        int check =nums[0];
        int n=nums.length;
        for(int i=1;i<n;i++){
            check&=nums[i];
        }
        if(check!=0) return 1;

        int cnt=0;
        int subarr=-1;
        for(int ele:nums){
            if(subarr==-1){
                subarr=ele;
            }
            subarr&=ele;
            if(subarr==0){
                cnt++;
                subarr=-1;
            }
        }
        return cnt;
    }
}