class Solution {
    public int removeDuplicates(int[] nums) {
        Map<Integer,Integer> map = new TreeMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int i=0;
        for(Map.Entry<Integer,Integer> val : map.entrySet()){
            if(val.getValue()>=2){
                nums[i++] =val.getKey();
                nums[i++] =val.getKey();
            }else{
                nums[i++] =val.getKey();
            }
        }
        return i;
    }
}