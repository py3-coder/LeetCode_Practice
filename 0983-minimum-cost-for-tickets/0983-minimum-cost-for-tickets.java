class Solution {
    public int r_solve2(int days[] , int costs[]){
        Set<Integer> set = new HashSet<>();
        for(int day:days) set.add(day);
        int lastday = days[days.length-1];
        int dp[] = new int[lastday+1];
        for(int i=1;i<=lastday;i++){
            if(!set.contains(i))
                dp[i] =dp[i-1];
            else{
                dp[i] =costs[0]+dp[i-1];
                
                int j = (i>=7) ? i-7: 0;
                    dp[i] =Math.min(dp[i],dp[j]+costs[1]);
                
                j=(i>=30)?i-30:0;
                    dp[i] =Math.min(dp[i],dp[j]+costs[2]);
            }  
        }
        return dp[lastday];
    }
        
    // r_solve --> Memoization;
    public int r_solve(int[] days,int[] costs,int day,int dp[]){
        if(day>=days.length){
            return 0;
        }
        if(dp[day] !=-1){
            return dp[day];
        }
        // 1 days pass
        int OnedayPass =costs[0]+r_solve(days,costs,day+1,dp);
        
        // 7 days pass
        int i;
        for(i=day;i<days.length && days[i]<days[day]+7;i++){ }
        int SevendayPass =costs[1]+r_solve(days,costs,i,dp);
        
        // 30 days pass
        for(i =day;i<days.length && days[i]< days[day]+30;i++){ }
        int ThirtydayPass =costs[2] +r_solve(days,costs,i,dp);
        
        //return min of all three;
        
        int res= Math.min(Math.min(OnedayPass,SevendayPass),ThirtydayPass);
        dp[day] =res;
        return dp[day];
        
    }
    public int mincostTickets(int[] days, int[] costs) {
        //int dp[] = new int[days.length];
        //Arrays.fill(dp,-1);
        //return r_solve(days,costs,0,dp);
        return r_solve2(days,costs);
    }
}