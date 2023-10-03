class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        //1. Recursion:
        // TC : O(2^n)
        //SC :O(1)
        // TestCase Passed All:)
        //return solveRec(arr,n,target);
        //2. Memo :) Since target range => -1000<=Traget <= 1000::
        // Can stote in 2d matrix : Think of other data structure -> HashMap ?
        int n =nums.length;
        ArrayList<Map<Integer,Integer>> memo = new ArrayList<>(n+1);
        for(int i=0;i<n+1;i++){
            memo.add(new HashMap<Integer,Integer>());
        }
        return solveMemo(nums, n, target,memo);
        //TC: O(n*target)
        //SC : O(n*target)
    }
    public static int solveRec(int[] arr,int n,int target){
        if(n==0){
            if(target==0){
                return 1;
            }
            return 0;
        }
        //add or substract::
        return solveRec(arr,n-1,target-arr[n-1])+solveRec(arr,n-1,target+arr[n-1]);
    }
    public static int solveMemo(int[] arr, int n,int target,ArrayList<Map<Integer,Integer>> memo){
        if(n==0){
            if(target==0){
                return 1;
            }
            return 0;
        }
        if(memo.get(n).containsKey(target)){
            return memo.get(n).get(target);
        }
        int ans=solveMemo(arr,n-1,target-arr[n-1],memo)+solveMemo(arr,n-1,target+arr[n-1],memo);
        //update the nth - map:
        memo.get(n).put(target,ans);
        return ans;
    }
}