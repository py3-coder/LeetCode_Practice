class Solution {
    public int minSubarray(int[] nums, int p) {
        int need =0,sum=0,n=nums.length,res=n;
        for(int a : nums){
            need =(need+a)%p;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i=0;i<nums.length;i++){
            sum = (sum+nums[i])%p;
            map.put(sum,i);
            int want = (sum-need+p)%p;
            res = Math.min(res,i-map.getOrDefault(want ,-n));
        }
        return res<n?res:-1;
    }
}