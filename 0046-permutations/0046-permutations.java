class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subres = new ArrayList<>();
        Solve(nums,subres,res);
        return res;
    }
    public static void Solve(int nums[],List<Integer> subres,List<List<Integer>> res){
        if(subres.size()==nums.length){
            res.add(new ArrayList<Integer>(subres));
            return;
        }else{
            for(int i=0;i<nums.length;i++){
                if(subres.contains(nums[i])) continue;
                subres.add(nums[i]);
                Solve(nums,subres,res);
                subres.remove(subres.size()-1);
            }
        }   
    }
    
}