class Solution {
    public int[] rearrangeArray(int[] nums) {
        //Broute Force :: make n/2 size 2 array put +ve in first and -ve in sec::
        //make new array insert carefully 1-1 from each::
        
        //TC : O(n)+O(n) -- atleast 2 traversal
        //SC : O(n/2)+O(n/2) -O(n) 
        
        
        //Optimised :: In Single Traversal:
        int res[] = new int[nums.length];
        int pos=0,neg=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                res[pos]=nums[i];
                pos+=2;
            }else{
                res[neg]=nums[i];
                neg+=2;
            }
        }
        return res;
        
        //TC : O(n)
        //SC : O(1)
    }
}