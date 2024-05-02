class Solution {
    public int findMaxK(int[] nums) {
        int[] cntp = new int[1001];
        int[] cntn = new int[1001];
        
        for(int ele : nums){
            if(ele>0){
                cntp[ele]++;
            }else{
                ele = Math.abs(ele);
                cntn[ele]++;
            }
        }
        
        for(int i=1000;i>=0;i--){
            if(cntp[i]>0 && cntn[i]>0){
                return i;
            }
        }
        return -1;
    }
}