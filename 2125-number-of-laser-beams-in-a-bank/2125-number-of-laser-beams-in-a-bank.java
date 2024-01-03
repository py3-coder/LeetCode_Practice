class Solution {
    public int numberOfBeams(String[] bank) {
        int n =bank.length;
        int beam=0;
        int prev=0;
        int zeroSecCnt=0;
        for(int i=0;i<n;i++){
            int cntSec=0;
            for(char ch:bank[i].toCharArray()){
                if(ch=='1'){
                    cntSec++;
                }
            }
            if(cntSec==0){
                zeroSecCnt++;
            }
            if(cntSec>0){
                beam +=prev*cntSec;
                prev =cntSec;
            }   
        }
        return beam;
        
    }
}