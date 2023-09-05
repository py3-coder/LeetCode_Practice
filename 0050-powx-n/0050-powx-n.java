class Solution {
    public double myPow(double x, int n) {
        // double ans=1;
        // if(n<0){
        //     n= (-1)*n;
        //     x=1/x;
        // }
        // while(n>0){
        //     if(n%2==1){
        //         n--;
        //         ans =ans*x;
        //     }else{
        //         n/=2;
        //         x=x*x;
        //     }
        // }
        // return ans;
        if(n < 0){
            n = -n;
            x = 1 / x;
        }
        
        double pow = 1;
        
        while(n != 0){
            if((n & 1) != 0){
                pow *= x;
            } 
                
            x *= x;
            n >>>= 1;
            
        }
        
        return pow;
        
    }
}