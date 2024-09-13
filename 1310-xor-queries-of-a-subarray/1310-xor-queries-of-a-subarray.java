class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
         int[] prefixXor = new int[arr.length + 1];
        for (int i = 0; i < arr.length; ++i)
            prefixXor[i + 1] = prefixXor[i] ^ arr[i];
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; ++i)
            ans[i] = prefixXor[queries[i][1] + 1] ^ prefixXor[queries[i][0]];
        return ans;     
    }
}