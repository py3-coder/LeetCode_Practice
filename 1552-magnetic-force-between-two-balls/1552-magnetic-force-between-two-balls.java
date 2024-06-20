class Solution {
    public int maxDistance(int[] position, int m) {
        int n = position.length;
        Arrays.sort(position);
        int max = position[n-1];
        int min = position[0];
        //edge :
        if(m == 2){
            return max-min;
        }
        int ans=0;
        int  l= 0 ,h = max-min;
        while(l<=h){
            int mid = l+(h-l)/2;
            if(isPossible(mid,m,position)){
                ans = mid;
                l = mid+1;
            }else{
                h = mid-1;
            }
        }
        return ans ;
    }
    public boolean isPossible(int mid , int m  , int[] positions){
        int count = 1;
        int last = positions[0];
        for (int i = 0; i < positions.length; i++) {
            if (positions[i] - last >= mid) {
                last = positions[i];
                count++;
            }
        }
        return count >= m; 
    }
}