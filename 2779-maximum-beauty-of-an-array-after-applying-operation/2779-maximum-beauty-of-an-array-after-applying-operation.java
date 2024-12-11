class Solution {
    public int maximumBeauty(int[] nums, int k) {
        // TC : nlogn
        // SC : constant
        
        
        Arrays.sort(nums);
        int start=0,end=0,ans=0;
        while(end<nums.length){
            if(nums[end]-nums[start]>2*k){
                start++;
            }
            ans = Math.max(end-start+1,ans);
            
            end++;
        }
        return ans;
        
        // TC : O(n)
        // SC : O(max+k)
        
//         int maxi=0;
        
//         for(int ele :nums){
//             maxi =Math.max(maxi , ele);
//         }
        
//         maxi +=k;
//         int[] line = new int[maxi+2];
        
//         for(int ele : nums){
//             int val = ele-k<0?0:ele-k;
//             line[val]++;
//             line[ele+k+1]--;
//         }
//         int cnt=0;
//         for(int i=1;i<=maxi;i++){
//             line[i]+=line[i-1];
//             cnt = Math.max(cnt , line[i]);
//         }
//         return cnt;
    }
}