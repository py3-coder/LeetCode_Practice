class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        //Lets Enjoy the Recursion::
        List<List<Integer>> res = new ArrayList<>();
        solveRecursion(k,1,n,res,new ArrayList<>());
        return res;
    }
    public static void solveRecursion(int k,int indx,int target,List<List<Integer>> res,List<Integer> temp){
        //base case :::
        if(k==0 && target==0){
            res.add(new ArrayList<>(temp));
            return;
        }
        if(k==0 || target==0){
            return;
        }
        
        for(int i=indx;i<=9;i++){
            if(i>target)  break;
            temp.add(i);
            solveRecursion(k-1,i+1,target-i,res,temp);
            temp.remove(temp.size()-1);
        }
        
    }
}