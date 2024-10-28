class Solution {
    public int longestSquareStreak(int[] A) {
        HashMap<Integer, Integer> dp = new HashMap<>();
        int res = 0;
        Arrays.sort(A);
        for(var i : A){
            int root = (int)Math.sqrt(i);
            if(root * root == i)  
               dp.put(i, dp.getOrDefault(root, 0) + 1);
            else  
               dp.put(i, 1);
            res = Math.max(res, dp.get(i));
        }
        return res < 2 ? -1 : res;
    }
}