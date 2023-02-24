class Solution {
    public int totalFruit(int[] tree) {
        int[] map = new int[40001];
        int cnt = 0;
        int max = 0;
        for (int l = 0, r = 0; r < tree.length; r++) {
            if (map[tree[r]]++ == 0)
                cnt++;
            while (cnt > 2) {
                if (--map[tree[l]] == 0)
                    cnt--;
                l++;
            }
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}