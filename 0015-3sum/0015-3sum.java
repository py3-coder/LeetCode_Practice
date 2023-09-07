class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        int n=arr.length;
         Set<List<Integer>> set =new HashSet<>();
        for(int i=0;i<n;i++){
            HashSet<Integer> hs = new HashSet<>();
            for(int j=i+1;j<n;j++){
                int target = -(arr[i]+arr[j]);
                if(hs.contains(target)){
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], target);
                        temp.sort(null);
                        set.add(temp);
                }
                hs.add(arr[j]);
            }
        }
       List<List<Integer>> res = new ArrayList<>(set);
       return res;
    }
}