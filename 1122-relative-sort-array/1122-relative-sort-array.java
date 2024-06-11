class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer,Integer> map = new TreeMap<>();
        Arrays.stream(arr1).forEach(ele -> map.put(ele,map.getOrDefault(ele,0)+1));
        int i = 0;
        for(int n : arr2) {
            for(int j = 0; j < map.get(n); j++) {
                arr1[i++] = n;
            }
            map.remove(n);
        }
        for(int n : map.keySet()){
            for(int j = 0; j < map.get(n); j++) {
                arr1[i++] = n;
            }
        }
        return arr1;
    }
}