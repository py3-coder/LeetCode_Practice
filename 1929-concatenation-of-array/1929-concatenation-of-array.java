class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int res[]  = new int[2*n];
        for(int i=0;i<n;i++){
           res[i+n] = res[i] = nums[i];
        }
        return res;
    }
}