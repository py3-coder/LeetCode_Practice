class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int p, q, answer[][], i = 0, j = 0;
        p = rowSum.length;
        q = colSum.length;
        answer = new int[p][q];
        while(i<p && j<q) {
            answer[i][j] = Math.min(rowSum[i], colSum[j]);
            rowSum[i] -= answer[i][j];
            colSum[j] -= answer[i][j];
            if(rowSum[i] == 0)
                i++;
            if(colSum[j] == 0)
                j++;
        }
        return answer;
    }
}