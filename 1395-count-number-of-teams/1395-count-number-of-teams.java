class Solution {
    public int numTeams(int[] rating) {
        if(rating == null || rating.length == 0){
            return 0;
        }
        
        int len = rating.length;
        int[] dp = new int[len];
        int count = 0;
        
        // first <r[i] <r[j] <r[k] order
        for(int i = 0; i < len; i++){
            for(int j = i; j >= 0; j--){
                if(rating[i] > rating[j]){
                    dp[i]++;
                    count = count + dp[j];
                }
            }
        }
        
        //System.out.println(count);
        dp = new int[len];
        
        for(int i = 0; i < len; i++){
            for(int j = i; j >= 0; j--){
                if(rating[i] < rating[j]){
                    dp[i]++;
                    count = count + dp[j];
                }
            }
        }
        
        return count;
        
    }
}