class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : arr) {
            map.put(a,map.getOrDefault(a,0)+1);
        }
        Set<Integer> seen = new HashSet<>();
        for (int freq : map.values()) {
            if (!seen.add(freq)) {
                return false;
            }
        }
        return true;
    }
}