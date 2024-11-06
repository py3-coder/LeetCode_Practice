class Solution {
    public boolean canSortArray(int[] nums) {int n=nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(nums[j]<nums[i]){
                    if(Integer.bitCount(nums[i])==
                    Integer.bitCount(nums[j])){
                        int temp=nums[i];
                        nums[i]=nums[j];
                        nums[j]=temp;
                    }
                    else return false;
                }
            }
        }
        for(int i=1;i<=n-1;i++){
            if(nums[i]<nums[i-1]) return false;
        }
        return true;
    }
}