class Solution {
    //TC :O(1)
    public int minFlips(int a, int b, int c) {
        int num=(a|b);
        int and=(a&b);
        int cnt=0;
        while(c>0 || num>0){
            if((c&1)!=(num&1)){
                if((c&1)==1){
                    cnt++;
                }else if((c&1)==0){
                    if((and&1)==1){
                        cnt+=2;
                    }else{
                        cnt++;
                    }
                }
            }
            c>>=1;
            num>>=1;
            and>>=1;
        }
        return cnt;
    }
}