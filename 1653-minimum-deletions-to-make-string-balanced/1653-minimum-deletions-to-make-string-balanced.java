class Solution {
    public int minimumDeletions(String s) {
        int cnt = 0;
        Deque<Character> stk = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (!stk.isEmpty() && stk.peek() == 'b' && c == 'a') {
                stk.pop();
                ++cnt;
            }else {
                stk.push(c);
            }
        }
        return cnt;
    }
}