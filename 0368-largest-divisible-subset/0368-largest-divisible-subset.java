class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // Parent Problem LIS :: Pattern::

        // Why dp Since We can't  decide wheather the first element will be the part of it or not 
        // so we try all possiblities to check it:: Means all ways::

        //why sorting since it we don't  do sorting we need to check will all elements so
        // after sorting we are sure that the prev elememt is smaller if the prev one is divisible 
        // with me means all value which are divisble with prev value must be divisible to me::

        Arrays.sort(nums);
        return solveLIS(nums);


    }
    public static List<Integer> solveLIS(int[] nums){
        int n=nums.length;
        int index[] = new int[n];
        int dp[] =new int[n];
        Arrays.fill(dp,1);

        for(int i=1;i<n;i++){
            index[i] =i;
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0 && dp[i]<1+dp[j]){
                    dp[i] =1+dp[j];
                    index[i]=j;
                }
            }
        }
        int ans=-1;
        int lastindex=-1;
        for(int i=0;i<n;i++){
            if(ans<dp[i]){
                ans =dp[i];
                lastindex=i;
            }
        }
        List<Integer> res = new ArrayList<>();
        res.add(nums[lastindex]);
        while(index[lastindex]!=lastindex){
            lastindex =index[lastindex];
            res.add(nums[lastindex]);
        }
        return res;

    }
}