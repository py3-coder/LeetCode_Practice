class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int maxi = Integer.MIN_VALUE;
        for(int quantity : quantities){
            maxi = Math.max(quantity , maxi) ;
        }
        
        int ans=0;
        int  l=1 , h = maxi;
        while(l<=h){
            int mid = l+(h-l)/2;
            if(isPossible(n,mid,quantities)){
                ans = mid;
                h= mid-1;
            }else{
                l= mid+1;
            }
        }
        return ans ;
    }
    
    public boolean isPossible(int n , int target , int[] quantities){
        int cnt  = 0;
        for(int ele : quantities){
            if(ele%target == 0){
                cnt += ele/target;
            }else{
                cnt += ele/target +1;
            }
        }
        return cnt <= n ;
    }
}