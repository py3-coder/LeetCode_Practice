class Solution {
     public int maxUniqueSplit(String s) {
        int[] res = new int[1];
        Set<String> set = new HashSet<>();
        
        dfs(res, s, set, 0);
        return res[0];
    }
    
    private void dfs(int[] res, String s, Set<String> set, int cur) {
        if (cur == s.length()) {
            res[0] = Math.max(res[0], set.size());
            return;
        }
        
        for (int i = cur; i < s.length(); i++) {
            String word = s.substring(cur, i + 1);
            if (!set.contains(word)) {
                set.add(word);
                dfs(res, s, set, i + 1);
                set.remove(word);
            }
        }
    }
}