class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        
        int maxi  = Integer.MIN_VALUE;
        for(int quantity : quantities){
            maxi = Math.max(quantity,maxi);
        }
        
        //Edge Case ::
        if(n == quantities.length){
            return maxi ;
        }
  
        int start = 1 ;
        int end = maxi ;
        int ans = Integer.MAX_VALUE;
        while(start <= end ){
            int mid = start +(end - start )/2;
            if(isPossible(mid,quantities,n)){
                ans = Math.min(mid , ans);
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return ans ;
    }
    
    public static boolean isPossible(int mid , int[] quantities,int n){
        int cnt=0;
        for(int quantity : quantities){
            cnt += Math.ceil(quantity*1.0/mid);
            
        }
        return cnt<=n;
    }
}