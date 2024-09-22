class Solution {
    // TLE
//     public int findKthNumber(int n, int k) {
//         long curr  = 1;
//         int p=1;
//         for(int i=1;i<=n;i++){
//             if(curr*10<=n){
//                 curr*=10;
//                 p++;
//             }
//             else if(curr%10!=9 && curr+1<=n){
//                 curr++;
//                 p++;
//             }else{
//                 while(((curr/10)%10)==9){
//                     curr/=10;
//                 }
//                 p++;
//                 curr = curr/10+1;
//             }
            
//             if(k==p){
//                 return (int)curr;
//             }
//         }
//         return 1;
//     }
    
    
    
    // Not my code : 
    public int findKthNumber(int n, int k) {
        long cur = 1;
        while(k > 1) {
            long gap = findGap(cur, cur + 1, n);
            if(gap <= k - 1) {
                k -= gap;
                cur = cur + 1;
            }
            else {
                cur = cur * 10;
                k -= 1;
            }
        }

        return (int)cur;
    }
    
    private long findGap(long a, long b, int n) {
        long gap = 0;
        while(a <= n) {
            gap += Math.min(n + 1, b) - a;
            a = a * 10;
            b = b * 10;
        }
        return gap;
    }
}

