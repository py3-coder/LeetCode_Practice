class Solution {
    public int minFlipsMonoIncr(String s) {
        // countflip , countOne ==0
        int countflip =0;
        int countOne=0;
        
        //iterate over loop
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0') countflip = Math.min(countflip+1,countOne);
            else{
                countOne+=1;
            }
        }
        return countflip;
    }
}