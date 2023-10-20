class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
			  int n=nums.length;
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
				
        Solve(n-1,nums,ans,res);
        for(List<Integer> obj:res){
            set.add(obj);
        }
        res.removeAll(res);
        for(List<Integer> obj:set){
            res.add(obj);
        }
        return res;
    }
    public static void Solve(int n ,int nums[],ArrayList<Integer> ans ,List<List<Integer>> res){
        if(n<0){
            res.add(new ArrayList<Integer>(ans));
            return;
        }
        //Pick
        ans.add(nums[n]);
        Solve(n-1,nums,ans,res);
        ans.remove(ans.size()-1);
        //Not pick 
        Solve(n-1,nums,ans,res);
    }
}