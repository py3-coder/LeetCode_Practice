class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res= new ArrayList<>();
        int n=candidates.length-1;
        solveRec(n,candidates,target,new ArrayList<>(),res);
        return res;
        
    }
    public static void solveRec(int n,int[] arr,int target,List<Integer> temp,List<List<Integer>> res){
        //BaseCase ::
        if(target==0){
            res.add(new ArrayList<>(temp));
            return ;
        }
        if(n<0) return;

        //choices we have ::
        if(arr[n]>target){
            //we can't pick::
            solveRec(n-1,arr,target,temp,res);
        }else{
            // 2 choices we have::
            //pick
            temp.add(arr[n]);
            solveRec(n,arr,target-arr[n],temp,res);
            temp.remove(temp.size()-1);
            //not pick:
            solveRec(n-1,arr,target,temp,res);
        }
    }
}