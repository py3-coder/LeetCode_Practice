class Solution {
    public int mySqrt(int x) {
        if(x==0 || x==1){
            return x;
        }
        long low =1;
        long high=x/2;
        while(low<=high){
            long mid = low+(high-low)/2;
            if(mid*mid<=x){
                low =mid+1;
            }else{
                high =mid-1;
            }
        }
        return (int)high;
    }
}