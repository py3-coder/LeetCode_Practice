class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        int ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> student = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < seats.length; i++) {
            pq.add(seats[i]);
            student.add(students[i]);
        }
        
        while (!pq.isEmpty()) {
            int a = pq.poll();
            int b = student.poll();
            ans += Math.abs(a - b);
        }
        
        return ans;
    }
}