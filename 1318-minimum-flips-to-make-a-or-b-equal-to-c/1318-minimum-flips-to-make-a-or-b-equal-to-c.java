class Solution {
    public int minFlips(int a, int b, int c) {
        int num=(a|b);
        int and=(a&b);
        int cnt=0;
        int maxi=Math.max(num,c);
        while(maxi!=0){
            // System.out.print((c&1)+"-");
            // System.out.print((num&1)+",");
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
            maxi>>=1;
        }
        return cnt;
    }
}