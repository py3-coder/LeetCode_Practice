class Solution {
    public int findJudge(int n, int[][] arr) {
        int[] trust = new int[n];
        int[] trusted = new int[n];
        for(int i = 0; i < arr.length; i++){
            int a = arr[i][0]; 
            int b = arr[i][1];
            trust[a - 1]++;
            trusted[b - 1]++;
        }
        for(int i = 0; i < n; i++){
            if(trust[i] == 0 && trusted[i] == n - 1)
                return i + 1;
        }
        return -1;
    }
}