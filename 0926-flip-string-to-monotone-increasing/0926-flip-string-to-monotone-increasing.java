class Solution {
    public int minFlipsMonoIncr(String s) {
        // countflip , countOne ==0
        int countflip =0;
        int countOne=0;
        
        //iterate over loop
        for(int i=0;i<s.length();i++){
            // As we counter 0 will increase countflip +1 and update 
            // countflip = min(countflip+1 , countOne)
            //  at any 0
            //      --> convert that zero to One
            //     ---> count no. of 1s upto now
            //        take min of both...
            if(s.charAt(i)=='0') countflip = Math.min(countflip+1,countOne);
            else{
                countOne+=1;
            }
        }
        return countflip;
    }
}
// Complexity 
// TC - O(n);
// SC -O(1);