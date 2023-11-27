class Solution {
    public int knightDialer(int N){
        int[][] dirs = new int[][]{{4,6},{6,8},{7,9},{4,8},{3,9,0},{},{1,7,0},{2,6},{1,3},{2,4}};
        
        int[][] dp = new int[ N + 1][10];
        for(int j = 0; j < dp[0].length; j ++){
            dp[1][j] = 1;
        }
        int mod = (int)1e9 + 7;
        for(int i = 2; i < dp.length;i ++)
            for(int j = 0; j < dp[0].length; j ++){
					
                int[] dir = dirs[j]; 	//Where j comes from
                for(int num : dir){
                    dp[i][j] += dp[i - 1][num]; 
                    dp[i][j] %= mod;
                }
            }
        int count = 0;
        for(int i = 0; i < dp[0].length; i ++){
            count += dp[N][i];
            count %= mod;
        }
       return count;
       
    }
}