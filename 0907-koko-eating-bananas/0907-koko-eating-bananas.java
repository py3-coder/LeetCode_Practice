class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int low =0;
        int high =Integer.MIN_VALUE;
        for(int ele: piles){
            high=Math.max(ele,high);
        }
        while(low<=high){
            int mid =low+(high-low)/2;
            if(isPossible(piles,mid,h)){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
    public static boolean isPossible(int[] piles,int rate,int h){
        int val=0;
        for(int ele:piles){
            val+=Math.ceil((double)(ele) /(double)(rate));
        }
        return (val<=h)?true:false;
    }
}