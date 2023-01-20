class Solution {
    HashSet<List<Integer>> hashset = new HashSet<>();
    int[] arr;
    public List<List<Integer>> findSubsequences(int[] nums) {
        arr = nums;
        List<Integer> lis = new ArrayList<>();
        recursion(lis,0);
        List<List<Integer>> res = new ArrayList<>(hashset);
        return res;
    }
    public void recursion(List<Integer> res , int indx){
        if(res.size()>=2) hashset.add(new ArrayList<>(res));
        for(int i=indx;i<arr.length;i++){
            if(res.size()==0 || arr[i]>=res.get(res.size()-1)){
                res.add(arr[i]);
                recursion(res,i+1);
                res.remove(res.size()-1);
            }
        }
    }
}