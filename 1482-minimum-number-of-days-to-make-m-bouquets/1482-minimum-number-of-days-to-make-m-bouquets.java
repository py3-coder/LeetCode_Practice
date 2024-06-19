class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        //edge cases :
        
        if(m>n) return -1;
        if((long)m*(long)k>n) return -1;
        
        int l = Integer.MAX_VALUE;
        int h=Integer.MIN_VALUE;
    
        for(int day : bloomDay){
            h = Math.max(h , day);
            l = Math.min(l , day);
        }
        
        //edge case
        if(m == n){
            return h;
        }
        int ans = h;
        while(l<=h){
            int mid  = l+(h-l)/2;
            if(isPossible(mid , bloomDay ,k ,m)){
                ans = mid;
                h = mid-1;
            }else{
                l = mid+1;
            }
        }
        return ans;
    }
    public boolean isPossible(int target , int[] arr ,int k ,int m){
        int cnt =0;
        int temp =0;
        for(int ele : arr) {
            if(ele<=target){
                temp++;
                if(temp == k){
                    cnt++;
                    temp =0;
                }
            }else{
                temp =0;
            }
        }
        return m <= cnt ;
    }
}