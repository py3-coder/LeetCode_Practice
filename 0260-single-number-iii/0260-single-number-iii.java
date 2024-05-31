class Solution {
    public int[] singleNumber(int[] nums) {
        // Broute Force : 
        // TC : O(nlogn) + O(n)
        // SC : O(1)
        
        // Using Map -
        // TC : O(n)
        // SC :O(n) 
        
        // Optimised :-
        // Bit Manupluation :
        
        
        
        int n = nums.length;
        if(n==2){
            return nums;
        }
        //xor of all means we will get the xor of 2 unique ele..
        // xor means same bit 0 diff bit 1.
        int xor =0;
        for(int ele:nums){
            xor^=ele;
        }
        
        //finding the the first diff bit so that we can part the array in 2 part to get two unique ele.
        // or simply we trying to find last set bit .
        
        //formula to find last set bit-
        xor &= ~(xor - 1);
        //int indx =0;
        // for(int i=0;i<(1<<5);i++){
        //     if(isbitset(xor,i)){
        //         indx =i;
        //         break;
        //     }
        // }
        int r1 =0,r2=0;
        for(int ele :nums){
            // if(isbitset(ele,indx)){
            //     r1^=ele;
            // }else{
            //     r2^=ele;
            // } 
            if((xor&ele) == 0){
                r1 ^=ele;
            }else{
                r2 ^=ele;
            }
        }
        return new int[]{r1,r2};
               
               
    }
    public boolean isbitset(int n,int pos){
        int mask = 1<<pos;
        if((n & mask)!=0) return true;
        return false;
    }
    
}