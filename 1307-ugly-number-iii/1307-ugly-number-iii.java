class Solution {
    int MAX=(int)2e9;
    public int nthUglyNumber(int n, int a, int b, int c) {
        // Imp ::
        // Ans Range : low =1 , high =2* 10^9 (given):
        // Now how to find how many ugly number exits between low and high which are divisible
        // a or b or c: Set Concept using venn digram::
        // F(n) =num/a+num/b+num/c -num/lcm(a,b) -num/lcm(b,c)-num/lcm(c,a)+num/lcm(a,b,c):
        int low=1,high=MAX;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(count(mid,a,b,c)>=n){ // finding mid as small as possible that count==n:
                high=mid-1;
            }else{
                low =mid+1;
            }
        }
        return low;
    }
    static int count(long num,long a,long b,long c){
        return (int)(num/a +num/b +num/c -num/lcm(a,b) - num/lcm(b,c) - num/lcm(c,a) + num/(lcm(a,lcm(b,c))));

    }
    static long  gcd(long a,long b){
        if(a==0) return b;
        return gcd(b%a,a);
    }
    static long lcm(long a ,long b){
        return a*b/gcd(a,b);
    }
}