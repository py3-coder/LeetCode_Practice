class Solution {
    static int memo[][] = new int[2501][2501];
    public int lengthOfLIS(int[] nums) {
        //Recursion:: TC: O(2^n) SC - O(1)+O(n) --Aux space::
        //return solveRec(0,-1,nums);

        // Memoization :) TC : O(n*n)  SC- O(n*n) +O(n) -Aux space::
        // Arrays.stream(memo).forEach(a->Arrays.fill(a,-1));
        // return solveMemo(0,-1,nums);

        // Tabulation -Bottom UP DP:) TC :O(n*n) SC : O(n*n)
        //return solveTab(nums);

        // Tabulation - Space Optmised :) TC : O(n*n) SC: O(n)
        //return solveOptimisationSpace(nums);
 
        // Diff Algo ::
        // TC : O(n*n)  SC : O(n)
        //return solveLCS(nums);

        // Binary Search Approch ::
        // TC : O(nlogn)
        // SC : O(n)
        return solveBS(nums);

       // return lengthOfLISBS(nums);

    }
    public static int solveRec(int indx,int prev,int nums[]){
        //Base Case ::
        if(indx>=nums.length) return 0;
        //choice we have : either part of LIS or not be the part of LIS:
        // Take not take case:: comes in picture::
        int pick=0;
        if(prev==-1 || nums[prev]<nums[indx]){
            pick = 1+solveRec(indx+1,indx,nums);
        }
        int notpick =solveRec(indx+1,prev,nums);
        return Math.max(pick,notpick);
    }
    public static int solveMemo(int indx,int prev,int nums[]){
        //Base Case ::
        if(indx>=nums.length) return 0;
        //choice we have : either part of LIS or not be the part of LIS:
        // Take not take case:: comes in picture::
        // why I am using prev+1 == because -1 indx not possible so increase every index by 1::
        if(memo[indx][prev+1]!=-1){
            return memo[indx][prev+1];
        }
        int pick=0;
        if(prev==-1 || nums[prev]<nums[indx]){
            pick = 1+solveMemo(indx+1,indx,nums);
        }
        int notpick =solveMemo(indx+1,prev,nums);
        return memo[indx][prev+1]=Math.max(pick,notpick);
    }
    public static int solveTab(int nums[]){
        //Tabulation::
        //Base :-> already handle due deafult value::
        //since we did co-ordinate shift:: prev index = index+1:
        int n=nums.length;
        int tab[][] = new int[n+1][n+1];

        for(int i=n-1;i>=0;i--){
            for(int j=i-1;j>=-1;j--){
                int pick=0;
                if(j==-1 || nums[j]<nums[i]){
                    pick = 1+tab[i+1][i+1];
                }
                int notpick =tab[i+1][j+1];

                tab[i][j+1]=Math.max(pick,notpick);
            }
        }
        return tab[0][-1+1];
    }
    public static int solveOptimisationSpace(int nums[]){
        //Observation :: 
        int n=nums.length;
        int curr[] = new int[n+1];
        int next[] =new int[n+1];

        for(int i=n-1;i>=0;i--){
            for(int j=i-1;j>=-1;j--){
                int pick =0;
                if(j==-1 || nums[j]<nums[i]){
                    pick =1+next[i+1];
                }
                int notpick =next[j+1];
                curr[j+1] =Math.max(pick,notpick);
            }
            next = curr.clone();
        }
        return curr[0];
    }
    // diff approch :: like till that idex what tha lcs ::
    // Do on papper eaily get it:
    public static int solveLCS(int nums[]){
        int n=nums.length;
        int lcs[] = new int[n+1];
        Arrays.fill(lcs,1);

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    lcs[i] =Math.max(lcs[i],lcs[j]+1);
                }
            }
        }
        int maxi=0;
        for(int ele:lcs){
            maxi=Math.max(ele,maxi);
        }
        return maxi;
    }
    public static int solveBS(int nums[]){
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);
        for(int i=1;i<nums.length;i++){
            if(temp.get(temp.size()-1)<nums[i]){
                temp.add(nums[i]);
            }else{
                int pos = binarySearch(nums[i],temp);
                temp.set(pos,nums[i]);
            }
        }
        return temp.size();
    }
    public static int binarySearch(int target,ArrayList<Integer> arr){
        int l =0;
        int h =arr.size()-1;

        while(l<=h){
            int m =l+(h-l)/2;
            if(arr.get(m)==target){
                return m;
            }else if(arr.get(m)>target){
                h=m-1;
            }else{
                l=m+1;
            }
        }
        return l;
    }
    public static int lengthOfLISBS(int[] nums) {            
        int[] dp = new int[nums.length];
        int len = 0;

        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if(i < 0) i = -(i + 1);
            dp[i] = x;
            if(i == len) len++;
        }
        return len;
    }
    
}