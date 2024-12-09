class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        // if both odd or even - incr cnt
        
        
        
        int n = nums.length;
        int[] pfsum = new int[n];
        pfsum[0] = 0;
        for(int i=1;i<n;i++){
            pfsum[i] = pfsum[i-1];
            if(((nums[i]&1)!=1 && (nums[i-1]&1)!=1)  || ((nums[i]&1)==1 && (nums[i-1]&1)==1)){
                pfsum[i]++;
            }
            
        }
        //queries :
        boolean res[] = new boolean[queries.length];
        int k=0;
        for(int[] q : queries){
            //start && end same :
            int cnt = pfsum[q[1]] - ((q[0]>0)?pfsum[q[0]]:0);
            res[k] = (cnt==0)?true:false;
            k++;
        }
        return res;
    }
}