class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        
        // Idea  -- Sort the array based on 1st indx .
        // Binary Search the array 
        
        int n = items.length;
        Arrays.sort(items,(a,b)->(a[0]==b[0])?(b[1]-a[1]):(a[0]-b[0]));
        
        int maxi = Integer.MIN_VALUE;
        for(int i=1;i<n;i++){
           items[i][1]  = Math.max(items[i-1][1] , items[i][1]);
           
        }
     
        int[] res =new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int start = 0;
            int end = n-1;
            while(start<=end){
                int mid = start+(end-start)/2;
                if(items[mid][0]<=queries[i]){
                    start =  mid+1 ;
                    res[i] = Math.max(res[i] , items[mid][1]);
                }else{
                    end = mid-1;
                }
            }
            
        }
        return res;
            
    }
}