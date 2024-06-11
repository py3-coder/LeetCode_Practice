class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        Map<Integer,Integer> map = new TreeMap<>();
        Arrays.stream(arr1).forEach(ele -> map.put(ele,map.getOrDefault(ele,0)+1));
        int k=0;
        for(int ele : arr2){
            set.add(ele);
            if(map.containsKey(ele)){
                int times = map.get(ele);
                while(times>0){
                    arr1[k] = ele;
                    k++;
                    times--;
                }
            }else{
                arr1[k] = ele;
                k++;
            }
        }
        for(int ele : map.keySet()){
            if(!set.contains(ele)){
                set.add(ele);
                int times = map.get(ele);
                while(times>0){
                    arr1[k] = ele;
                    k++;
                    times--;
                }
            }
        }
        return arr1;
    }
}