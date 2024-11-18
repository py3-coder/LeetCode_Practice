class Solution {
    public int countValidSelections(int[] nums) {
        int cnt =0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                int lfs = sum(0,i,nums);
                int rfs = sum(i+1,n,nums);
                if(lfs == rfs ){
                    cnt+=2;
                }else if(Math.abs(lfs-rfs)==1){
                    cnt+=1;
                }
            }
        }
        return cnt ;
    }
    
    public int sum(int start , int end , int[] nums){
        int ans =0; 
        for(int i= start ; i<end;i++){
            ans +=nums[i];
        }
        return ans ;
    }
}