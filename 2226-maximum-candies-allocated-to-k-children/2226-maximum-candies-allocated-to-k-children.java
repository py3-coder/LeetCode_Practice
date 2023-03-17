class Solution {
    public int maximumCandies(int[] candies, long k) {
        long sum = 0;
        for(int i = 0 ; i < candies.length; i++){
            sum+= candies[i];
        }
        int res =0;
        int start = 1;
        int end= (int)(sum/k);
       
        while(start <= end){
            int mid = start +(end-start)/2;
            long count = 0;
            
            for(int i = 0 ; i < candies.length; i++){
                count+= candies[i]/mid;
            }
            if(count >= k){
                res = mid;
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return res;
    }
}
