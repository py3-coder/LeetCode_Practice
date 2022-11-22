class Solution {
    public int numSquares(int n) {
        List<Integer> squares = new ArrayList<>();

        int cur = 1;
        // Build the squares array
        while (Math.pow(cur, 2) <= n) {
            squares.add((int) Math.pow(cur++, 2));
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        // Base case
        dp[0] = 0;
        for (int i = 1; i < n+1; i++ ) {
            // DP transition
            for (int j = 0; j < squares.size() && squares.get(j) <= i; j++) {
                dp[i] = Math.min(dp[i], 1 + dp[i-squares.get(j)]);
            }
        }
        return dp[n];

    }
}