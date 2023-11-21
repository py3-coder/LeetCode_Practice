class Solution {
    static int[] memo;
    public boolean canJump(int[] nums) {
        if(nums.length==1) return true;
        //return solveRec(nums,0)==0?false:true;
        // memo =new int[nums.length];
        // Arrays.fill(memo,-1);
        // return solveMemo(nums,0)==0?false:true;
        
        return solveGreedy(nums);
    }
    //Recursion :)::
    public static int solveRec(int[] nums,int indx){
        if(indx==nums.length-1) return 1;
        if(nums[indx]==0) return 0;
        int flag=0;
        for(int i=1;i<=nums[indx] && indx+i<nums.length;i++){
            if(flag==1){
                return 1;
            }
            flag =Math.max(solveRec(nums,indx+i),flag);
        }
        return flag;
    }
    //Memo ::
    // TC :O(n^2) 
    // SC :O(n) +O(n) --Aux space ::
    public static int solveMemo(int[] nums,int indx){
        if(indx==nums.length-1) return 1;
        if(nums[indx]==0) return 0;
        
        if(memo[indx]!=-1){
            return memo[indx];
        }
        int flag=0;
        for(int i=1;i<=nums[indx] && indx+i<nums.length;i++){
            if(flag==1){
                return memo[indx+i]=1;
            }
            flag =Math.max(solveMemo(nums,indx+i),flag);
        }
        return memo[indx]=flag;
    }
    
    //Greedy Approch ::
    public static boolean solveGreedy(int[] nums){
        if(nums.length==1) return true;
        int reach =0;
        for(int i=0;i<nums.length;i++){
            if(reach<i) return false;
            reach =Math.max(nums[i]+i,reach);
        }
        return true;
    }
}