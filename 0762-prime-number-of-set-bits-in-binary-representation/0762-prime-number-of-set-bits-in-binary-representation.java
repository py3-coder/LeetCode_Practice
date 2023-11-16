class Solution {
    public int countPrimeSetBits(int left, int right) {
        //TC : O()
        int cnt=0;
        for(int i=left;i<=right;i++){
            int cntset=0;
            for(int j=0;j<32;j++){
                if((i &(1<<j))!=0){
                    cntset++;
                }
            }
           //System.out.println(i+"-"+cntset);
            if(isPrime(cntset)){
                cnt++;
            }
        }
        return cnt;
    }
    public static boolean isPrime(int n){
        if(n==1) return false;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}