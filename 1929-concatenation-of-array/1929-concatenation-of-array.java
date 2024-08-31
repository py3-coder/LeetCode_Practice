class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int res[]  = new int[2*n];
        for(int i=0;i<2*n;i++){
            res[i] = nums[i%n];
        }
        return res;
    }
}