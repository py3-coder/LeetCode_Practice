class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        return solveRec(nums,k,new ArrayList<>(),n);
    }
    public int solveRec(int[] nums,int k,List<Integer> lis,int n){
        //Base 
        if(n==0 && lis.size()!=0){
            return 1;
        }
        if(n<=0){
            return 0;
        }
        int take=0,notake=0;
        if(!lis.contains(nums[n-1]+k)){
            //pick =
            lis.add(nums[n-1]);
            take =solveRec(nums,k,lis,n-1);
            lis.remove(lis.size()-1);
        }
        //not pick
        notake =solveRec(nums,k,lis,n-1);
        return take+notake;
        
    }
}