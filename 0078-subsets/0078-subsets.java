class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n=nums.length-1;
        solveRec(n,nums,new ArrayList<>(),res);
        return res;
        
    }
    public static void solveRec(int n,int[] nums,List<Integer> temp,List<List<Integer>> res){
        //Base Case ::
        if(n<0){
            res.add(new ArrayList<>(temp));
            return ;
        }

        //pick 
        temp.add(nums[n]);
        solveRec(n-1,nums,temp,res);
        temp.remove(temp.size()-1);
        //not pick case::
        solveRec(n-1,nums,temp,res);  
    }
}