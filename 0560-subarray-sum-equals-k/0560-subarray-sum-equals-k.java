class Solution {
    public int subarraySum(int[] nums, int k) {
        int count=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum=0;
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int due=sum-k;
            if(map.containsKey(due)){
                count+=map.get(due);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}