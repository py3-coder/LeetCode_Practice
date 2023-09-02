class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int len=s.length();
        int dp[]=new int[len];
        Arrays.fill(dp,-1);
        Set<String> nm=new HashSet<>();
        for(String k:dictionary)
        {
            nm.add(k);
        }
        return task(dp,s,len,0,nm);
    }
    public int task(int dp[], String s, int len, int ind, Set<String> nm)
    {
        if(ind==len)
        {
            return 0;
        }
        if(dp[ind]!=-1)
        {
            return dp[ind];
        }
        StringBuilder k=new StringBuilder();
        int ans=len;
        for(int point=ind;point<len;point++)
        {
            k.append(s.charAt(point));
            int val=nm.contains(k.toString()) ? 0 : k.length();
            int val1=task(dp,s,len,point+1,nm);
            ans=Math.min(ans,val+val1);
        }
        return dp[ind]=ans;
    }
}