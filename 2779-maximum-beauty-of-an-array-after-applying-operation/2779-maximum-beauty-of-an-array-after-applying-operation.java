class Solution {
    public int maximumBeauty(int[] nums, int k) {
        int maxi=0;
        
        for(int ele :nums){
            maxi =Math.max(maxi , ele);
        }
        
        maxi +=k;
        int[] line = new int[maxi+2];
        
        for(int ele : nums){
            int val = ele-k<0?0:ele-k;
            line[val]++;
            line[ele+k+1]--;
        }
        int cnt=0;
        for(int i=1;i<=maxi;i++){
            line[i]+=line[i-1];
            cnt = Math.max(cnt , line[i]);
        }
        return cnt;
    }
}