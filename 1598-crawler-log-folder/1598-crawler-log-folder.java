class Solution {
    public int minOperations(String[] logs) {
        int res = 0;
        for (String s : logs) {
            if (s.equals("../")) res = Math.max(0, --res);
            else if (s.equals("./")) continue;
            else res++;
        }
        return res;
    }
}

