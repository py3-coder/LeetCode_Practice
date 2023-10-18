class Solution {
    static HashMap<String,Integer> map;
    public int longestArithSeqLength(int[] nums) {
        // Recursion::1.
        //return solveRec(nums,0,501,-1,0);

        // Recursion Modiied::2
        // return solve(Integer.MIN_VALUE,Integer.MIN_VALUE,nums,0);

        // map =new HashMap<>();
        // return solveMemo(Integer.MIN_VALUE,Integer.MIN_VALUE,nums,0);
        return solveTab(nums);
        
    }
    public static int solveRec(int[] nums,int indx,int diff,int prev,int len){
        //base case:::
        if(indx>=nums.length) return 0;
        if(diff==501){
            int pick=0;
            if(len<1){
                pick =1+solveRec(nums,indx+1,diff,indx,len+1);
            }else {
                pick =1+solveRec(nums,indx+1,nums[indx]-nums[prev],indx,len+1);
            }
            int notpick =solveRec(nums,indx+1,diff,prev,len);
            return Math.max(pick,notpick);
        }else{
            int pick=0;
            if(nums[indx]-nums[prev]==diff){
                pick =1+solveRec(nums,indx+1,diff,indx,len+1);
            }
            int notpick =solveRec(nums,indx+1,diff,prev,len);
            return Math.max(pick,notpick);
        }
    }
    public static int solve(int prev,int diff,int[] nums,int indx){
        if(indx==nums.length) return 0;
        int pick=0;
        int notpick=0;

        if(prev==Integer.MIN_VALUE){
            pick =1+solve(nums[indx],diff,nums,indx+1);
        }else if(diff==Integer.MIN_VALUE || diff == nums[indx]-prev){
            pick=1+solve(nums[indx],nums[indx]-prev,nums,indx+1);
        }
        notpick =solve(prev,diff,nums,indx+1);
        return Math.max(pick,notpick);
    }
    public static int solveMemo(int prev,int diff,int[] nums,int indx){
        if(indx==nums.length) return 0;

        String key =indx+"-"+prev+"-"+diff;
        if(map.containsKey(key)){
            return map.get(key);
        }
        int pick=0;
        int notpick=0;

        if(prev==Integer.MIN_VALUE){
            pick =1+solveMemo(nums[indx],diff,nums,indx+1);
        }else if(diff==Integer.MIN_VALUE || diff == nums[indx]-prev){
            pick=1+solveMemo(nums[indx],nums[indx]-prev,nums,indx+1);
        }
        notpick =solveMemo(prev,diff,nums,indx+1);
        map.put(key,Math.max(pick,notpick));
        return Math.max(pick,notpick);
    }
    public static int solveTab(int[] nums){
        int n=nums.length;
        
        if(n<=2) return n;
        Map<Integer, Integer>[] dp = new HashMap[n];
        int longest=2;
        for(int i=0;i<n;i++){
            dp[i] =new HashMap<>();
            for(int j=0;j<i;j++){
                int diff =nums[i]-nums[j];
                dp[i].put(diff,dp[j].getOrDefault(diff,1)+1);
                longest =Math.max(longest,dp[i].get(diff));
            }
        }
        return longest;
    }

}