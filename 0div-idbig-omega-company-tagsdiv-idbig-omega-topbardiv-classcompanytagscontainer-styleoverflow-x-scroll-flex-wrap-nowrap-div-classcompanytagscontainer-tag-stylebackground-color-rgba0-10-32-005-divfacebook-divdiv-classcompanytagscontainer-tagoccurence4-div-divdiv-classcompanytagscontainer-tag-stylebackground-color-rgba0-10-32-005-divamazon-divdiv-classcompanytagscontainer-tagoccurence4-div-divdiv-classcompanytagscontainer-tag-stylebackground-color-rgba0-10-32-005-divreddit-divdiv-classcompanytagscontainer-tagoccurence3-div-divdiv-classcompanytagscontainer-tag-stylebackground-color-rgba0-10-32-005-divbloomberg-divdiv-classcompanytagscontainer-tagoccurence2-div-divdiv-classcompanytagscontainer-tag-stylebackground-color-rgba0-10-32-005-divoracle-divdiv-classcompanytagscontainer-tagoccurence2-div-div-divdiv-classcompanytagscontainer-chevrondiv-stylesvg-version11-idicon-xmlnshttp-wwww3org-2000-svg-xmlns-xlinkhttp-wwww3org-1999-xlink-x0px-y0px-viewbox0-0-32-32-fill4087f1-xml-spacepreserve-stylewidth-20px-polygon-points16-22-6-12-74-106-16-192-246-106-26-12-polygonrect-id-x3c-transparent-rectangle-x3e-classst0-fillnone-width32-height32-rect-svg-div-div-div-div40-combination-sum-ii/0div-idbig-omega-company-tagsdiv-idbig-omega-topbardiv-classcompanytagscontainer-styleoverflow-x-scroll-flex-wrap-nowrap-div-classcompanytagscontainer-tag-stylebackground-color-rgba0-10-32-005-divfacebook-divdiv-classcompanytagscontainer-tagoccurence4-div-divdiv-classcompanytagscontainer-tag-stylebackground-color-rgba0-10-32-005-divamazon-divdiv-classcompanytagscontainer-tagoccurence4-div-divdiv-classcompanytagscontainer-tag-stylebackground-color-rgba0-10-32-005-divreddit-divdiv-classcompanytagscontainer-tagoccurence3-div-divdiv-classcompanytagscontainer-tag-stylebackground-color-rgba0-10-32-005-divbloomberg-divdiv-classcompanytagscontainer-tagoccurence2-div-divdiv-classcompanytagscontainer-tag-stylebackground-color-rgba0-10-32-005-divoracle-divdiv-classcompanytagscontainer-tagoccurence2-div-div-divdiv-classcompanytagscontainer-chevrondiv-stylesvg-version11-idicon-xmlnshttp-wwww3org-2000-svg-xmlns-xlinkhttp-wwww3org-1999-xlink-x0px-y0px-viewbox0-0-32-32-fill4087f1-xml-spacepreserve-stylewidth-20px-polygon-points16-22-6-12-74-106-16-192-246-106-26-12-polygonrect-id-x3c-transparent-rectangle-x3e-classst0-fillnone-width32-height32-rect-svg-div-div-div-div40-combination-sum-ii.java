class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //Lets Enjoy Recursion:::
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        solveRecursion(candidates,0,target,res,new ArrayList<>());
        return res;
        
    }
    public static void solveRecursion(int[] arr,int indx,int target,List<List<Integer>> res,List<Integer> temp){
        if(target==0){
            res.add(new ArrayList<>(temp));
            return ;
        }
        ///since we need to run loop:: as per tree diagram::
        for(int i=indx;i<arr.length;i++){
            if(i>indx && arr[i]==arr[i-1]) continue;
            if(arr[i]>target) break;
            temp.add(arr[i]);
            solveRecursion(arr,i+1,target-arr[i],res,temp);
            temp.remove(temp.size()-1);
        }
    }
}