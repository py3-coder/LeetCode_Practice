class Solution {
    public double myPow(double x, int n) {
        // B H I Method :: BaseCase Hypothesis Induction ::
        //Base Case::
        if(n==0){
            return 1;
        }
        //to handle edge case for Int
        long N=n;
        // to handle -ve case::
        if(N<0){
            N =-N;
            x =1/x;
        }
        //just a easy catch --- x^8 --> x^(2*4)
        if(N%2==0){
            return myPow(x*x,(int)(N/2));
        }else{
            return x*myPow(x,(int)N-1);
        }
    }
}
