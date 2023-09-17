class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count=0;
        int maxi =0;
        for(int val : nums){
            if(val==1){
                count++;
                maxi =Math.max(maxi,count);
            }else if(val==0){
                count=0;
            }
        }
        return maxi;
    }
}