import java.util.*;

class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        TreeMap<Integer, Integer> rangeMap = new TreeMap<>();
        Set<Integer> points = new TreeSet<>();
     
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            rangeMap.put(num - k, rangeMap.getOrDefault(num - k, 0) + 1);
            rangeMap.put(num + k + 1, rangeMap.getOrDefault(num + k + 1, 0) - 1);
            points.add(num);
            points.add(num - k);
            points.add(num + k + 1);
        }
        
       
        int ans = 1;
        int sum = 0; 

        for (int point : points) {
            sum += rangeMap.getOrDefault(point, 0);
            int frequency = freqMap.getOrDefault(point, 0);
            ans = Math.max(ans, frequency + Math.min(sum - frequency, numOperations));
        }
        
        return ans;
    }
}
