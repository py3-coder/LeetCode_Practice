class Solution {
    public int minFallingPathSum(int[][] A) {
        for(int i=1; i<A.length; i++)
        {
            int[] min = getMinOneAndTwo(A[i-1]);
            for(int j=0; j<A.length; j++)
            {
                if(A[i-1][j]==min[0])
                    A[i][j]+=min[1];
                else
                    A[i][j]+=min[0];                    
            }
        }
        
        int min = Integer.MAX_VALUE;
        for(int i=0; i<A.length; i++)
        {
            min=Math.min(min, A[A.length-1][i]);
        }
        return min;
    }
    
    private int[] getMinOneAndTwo(int[] nums)
    {
        int[] res = new int[2];
        res[0] = res[1] = Integer.MAX_VALUE;
        for(int num:nums)
        {
            if(res[0]>num)
            {
                res[1]=res[0];
                res[0]=num;
                continue;
            }
            if(res[1]>num)
            {
                res[1]=num;
            }
        }
        return res;
    }
    
}