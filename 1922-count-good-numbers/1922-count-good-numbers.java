class Solution {
    public long MOD = 1000000007;
    public int countGoodNumbers(long n) {
        // You need to figure a pattern::
        // n==1 ==> {0,2,4,6,7}        ===> 5
        // n==2  ==> 02,03,05,07
        //           22,23,25,27
        //           42,43,45,47
        //           62,63,65,67
        //           82,83,85,87            ==> 20 ==> 5*4
        // n==3                             ==> 200 ==> 5*4*5
        // pattern goes as --> 545454545.......... 
        
        long four =n/2;
        long five =(n+1)/2;
        return (int)(pow(5, five)*pow(4, four)%MOD);
        
        
    }
    public long pow(long x, long n) {
        if(n==0) return 1;
        long temp = pow(x,n/2);
        if(n%2==0){
            return (temp*temp)%MOD;
        }
        else{
            return (x*temp*temp)%MOD;
        }
    }
}