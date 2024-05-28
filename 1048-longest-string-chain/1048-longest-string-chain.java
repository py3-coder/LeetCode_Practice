class Solution {
    public int longestStrChain(String[] words) {
        if(words.length==1){
            return 1;
        }
        int n  = words.length;
        Arrays.sort(words,(a,b)->(a.length()-b.length()));
        return solveLIS(n,words);
        
    }
    public int solveLIS(int n, String[] words){
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int maxi =0;
        for(int i=1;i<words.length;i++){
            for(int j=0;j<i;j++){
                if(check(words[i],words[j]) && 1+dp[j]>dp[i]){
                    dp[i] = 1+dp[j];
                }
            }
            maxi = Math.max(maxi,dp[i]);
        }
        return maxi;
    }
    public boolean check(String a , String b){
        if(a.length()!=b.length()+1) return false;
        
        int f=0,s=0;
        while(f<a.length()){
            if(s<b.length() && a.charAt(f)== b.charAt(s)){
                f++;
                s++;
            }else{
                f++;
            } 
        }
        return f==a.length() && s == b.length(); 
    }
}