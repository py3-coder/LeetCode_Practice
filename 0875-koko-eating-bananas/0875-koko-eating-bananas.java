class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int  high=Integer.MIN_VALUE;
        for(int val:piles){
            high =Math.max(val,high);
        }
        while(low<=high){
            int mid =low+(high-low)/2;
            int ans =check(mid,piles);
            if(ans<=h){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
    public static int check(int mid,int[] arr){
        int ans=0;
        for(int val:arr){
            ans+=Math.ceil((double)(val) /(double)(mid));
        }
        return ans;
    }
}