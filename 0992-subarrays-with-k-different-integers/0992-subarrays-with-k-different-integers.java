class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return solveatMost(nums,k)-solveatMost(nums,k-1);
    }
    public static int solveatMost(int[] nums,int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        int start=0;
        int end=0;
        int res=0;
        while(end<nums.length){
            map.put(nums[end],map.getOrDefault(nums[end],0)+1);
            while(map.size()>k ){
                int val=map.get(nums[start]);
                if(val==1){
                    map.remove(nums[start]);
                }else{
                    map.put(nums[start],map.get(nums[start])-1);
                }
                start++;
            }
            res+=end-start+1;
            end++;
        }
        return res;
    }
}