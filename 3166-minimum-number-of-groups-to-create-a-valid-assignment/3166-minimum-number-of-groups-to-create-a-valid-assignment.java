class Solution {
    public int minGroupsForValidAssignment(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int mincount=Integer.MAX_VALUE;
        for(int count:map.values()){
            mincount =Math.min(mincount,count);
        }
        for(int i=mincount;i>0;i--){
            int groups = 0;
            for (int curr : map.values()) {
                int rem = curr%(i+1);
                int numGroups = curr/(i+1);
                if (rem == 0) {
                    groups += numGroups;
                } else if (numGroups >= i - rem) {
                    groups += numGroups + 1;
                } else {
                    groups = 0;
                    break;
                }
            }
            if(groups>0) return groups;
        }
        return  nums.length;
    }
}