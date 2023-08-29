class Solution {
    public int longestOnes(int[] A, int K) {
        int zeroCount=0;
        int start=0,res=0;
        for(int end=0;end<A.length;end++){
            if(A[end] == 0) zeroCount++;
            if(zeroCount > K){
                if(A[start] == 0) zeroCount--;
                start++;
            }
            res=Math.max(res,end-start+1);
        }
        return res;
    }
}