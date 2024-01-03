class Solution {
    public int numberOfBeams(String[] bank) {
        int n =bank.length;
        int[] securityCnt =new int[n];
        int zeroSecCnt=0;
        for(int i=0;i<n;i++){
            int cntSec=0;
            for(char ch:bank[i].toCharArray()){
                if(ch=='1'){
                    cntSec++;
                }
            }
            securityCnt[i]=cntSec;
            if(cntSec==0){
                zeroSecCnt++;
            }
        }
        
        // Case when only single row have security gards:: no bream::
        if(zeroSecCnt==n-1){
            return 0;
        }
        int beam=0;
        int prev=0;
        for(int i=0;i<n;i++){
            if(securityCnt[i]==0){
                continue;
            }
            beam+=prev*securityCnt[i];
            prev=securityCnt[i];
        }
        return beam;
        
    }
}