class Solution {
    public long maxKelements(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int n = arr.length;
        long answer = 0;
        for(int i=0; i<n; i++)  queue.add(arr[i]);
        for(int i=0; i<k; i++){
            int temp = queue.poll();
            answer += temp;
            double s = (double)temp/3;
            queue.add((int)Math.ceil(s));
        }
        return answer;
    }
}