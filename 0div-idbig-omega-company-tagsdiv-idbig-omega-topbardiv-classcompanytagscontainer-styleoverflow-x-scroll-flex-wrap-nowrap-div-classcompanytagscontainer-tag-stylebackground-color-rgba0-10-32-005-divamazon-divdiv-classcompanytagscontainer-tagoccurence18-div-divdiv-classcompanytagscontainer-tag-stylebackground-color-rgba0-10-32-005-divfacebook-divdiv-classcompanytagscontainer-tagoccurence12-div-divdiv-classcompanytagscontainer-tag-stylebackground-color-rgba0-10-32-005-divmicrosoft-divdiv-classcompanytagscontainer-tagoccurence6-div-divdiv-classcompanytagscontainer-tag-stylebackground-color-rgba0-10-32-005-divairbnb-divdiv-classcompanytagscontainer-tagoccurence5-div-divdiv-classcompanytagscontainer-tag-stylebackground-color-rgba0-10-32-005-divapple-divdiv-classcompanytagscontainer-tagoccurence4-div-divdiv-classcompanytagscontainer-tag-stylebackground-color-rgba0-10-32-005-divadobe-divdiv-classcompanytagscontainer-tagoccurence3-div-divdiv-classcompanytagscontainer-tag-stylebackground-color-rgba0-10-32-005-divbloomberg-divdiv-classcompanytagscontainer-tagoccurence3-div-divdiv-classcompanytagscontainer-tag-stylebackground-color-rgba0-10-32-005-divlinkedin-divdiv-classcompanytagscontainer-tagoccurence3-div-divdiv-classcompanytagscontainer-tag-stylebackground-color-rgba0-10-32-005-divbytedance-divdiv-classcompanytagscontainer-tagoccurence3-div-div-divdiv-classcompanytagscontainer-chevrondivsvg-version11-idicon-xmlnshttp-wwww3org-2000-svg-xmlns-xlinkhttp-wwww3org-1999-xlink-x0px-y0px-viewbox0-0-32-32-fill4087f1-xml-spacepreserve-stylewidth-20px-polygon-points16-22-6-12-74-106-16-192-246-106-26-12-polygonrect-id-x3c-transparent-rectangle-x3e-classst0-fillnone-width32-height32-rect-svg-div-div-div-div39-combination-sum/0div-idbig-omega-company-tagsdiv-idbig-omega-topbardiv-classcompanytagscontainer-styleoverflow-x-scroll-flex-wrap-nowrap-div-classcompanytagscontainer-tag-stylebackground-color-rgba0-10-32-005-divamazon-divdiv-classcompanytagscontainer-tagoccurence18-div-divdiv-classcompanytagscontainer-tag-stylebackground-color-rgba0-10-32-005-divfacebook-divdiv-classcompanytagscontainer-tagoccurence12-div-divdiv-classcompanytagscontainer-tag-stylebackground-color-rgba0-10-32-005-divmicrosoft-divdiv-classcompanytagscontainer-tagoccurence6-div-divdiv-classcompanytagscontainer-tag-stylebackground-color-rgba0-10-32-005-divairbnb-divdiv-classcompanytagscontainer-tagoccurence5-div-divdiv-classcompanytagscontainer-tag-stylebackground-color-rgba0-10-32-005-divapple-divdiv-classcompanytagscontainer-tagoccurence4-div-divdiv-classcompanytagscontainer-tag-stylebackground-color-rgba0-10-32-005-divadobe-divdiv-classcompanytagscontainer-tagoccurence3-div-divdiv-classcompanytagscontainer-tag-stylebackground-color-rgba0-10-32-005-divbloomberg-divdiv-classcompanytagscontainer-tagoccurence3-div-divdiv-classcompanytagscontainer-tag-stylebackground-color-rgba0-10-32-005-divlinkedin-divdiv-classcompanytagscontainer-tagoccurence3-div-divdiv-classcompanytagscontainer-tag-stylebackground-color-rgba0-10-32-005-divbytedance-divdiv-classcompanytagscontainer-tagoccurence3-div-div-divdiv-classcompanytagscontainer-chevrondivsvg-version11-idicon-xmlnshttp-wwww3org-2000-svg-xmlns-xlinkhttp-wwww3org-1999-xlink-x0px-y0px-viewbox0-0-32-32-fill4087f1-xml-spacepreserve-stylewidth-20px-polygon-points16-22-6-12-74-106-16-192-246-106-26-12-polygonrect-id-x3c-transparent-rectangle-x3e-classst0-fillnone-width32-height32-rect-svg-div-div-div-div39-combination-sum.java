class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //Lets Enjoy Recursion  :::
        List<List<Integer>> res = new ArrayList<>();
        solveRecursion(candidates,0,target,res,new ArrayList<>());
        return res;
        
    }
    public static void solveRecursion(int[] arr, int indx,int target,List<List<Integer>> res,List<Integer> temp){
        //Base Case :::
        if(target == 0){
            res.add(new ArrayList<>(temp));
            return ;
        }
        if(indx == arr.length)
            return;
        if(arr[indx]<=target){
            temp.add(arr[indx]);
            solveRecursion(arr,indx,target-arr[indx],res,temp);
            temp.remove(temp.size()-1);
        }
        solveRecursion(arr,indx+1,target,res,temp);
    }
}