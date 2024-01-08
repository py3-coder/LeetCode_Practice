class Solution {
    public int maximumSetSize(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 =new HashSet<>();
        HashSet<Integer> set2 =new HashSet<>();
        HashSet<Integer> common =new HashSet<>();
        
        for(int ele:nums1){
            set1.add(ele);
            common.add(ele);
        }
        for(int ele:nums2){
            set2.add(ele);
            common.add(ele);
        }
        return Math.min(Math.min(set1.size(),nums1.length/2)+Math.min(set2.size(),nums1.length/2),common.size());
    } 
}
