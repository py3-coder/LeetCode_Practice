class Solution {
    public int removeDuplicates(int[] nums) {
        SortedSet<Integer> set = new TreeSet<>();
        for(int val:nums){
            set.add(val);
        }
        int i=0;
        for(int val:set){
            nums[i]=val;
            i++;
        }
        return set.size();
    }
}