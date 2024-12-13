import java.util.*;

class Solution {
//     public int maxFrequency(int[] nums, int k, int numOperations) {
//         Map<Integer, Integer> freqMap = new HashMap<>();
//         TreeMap<Integer, Integer> rangeMap = new TreeMap<>();
//         Set<Integer> points = new TreeSet<>();
     
//         for (int num : nums) {
//             freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
//             rangeMap.put(num - k, rangeMap.getOrDefault(num - k, 0) + 1);
//             rangeMap.put(num + k + 1, rangeMap.getOrDefault(num + k + 1, 0) - 1);
//             points.add(num);
//             points.add(num - k);
//             points.add(num + k + 1);
//         }
        
       
//         int ans = 1;
//         int sum = 0; 

//         for (int point : points) {
//             sum += rangeMap.getOrDefault(point, 0);
//             int frequency = freqMap.getOrDefault(point, 0);
//             ans = Math.max(ans, frequency + Math.min(sum - frequency, numOperations));
//         }
        
//         return ans;
//     }
    public int maxFrequency(int[] nums, int k, int numOperations) {
        HashMap<Integer,Integer> freq = new HashMap<>();
        int maxi = 0; 
        for(int ele : nums){ 
            freq.put(ele , freq.getOrDefault(ele,0)+1);
            maxi = Math.max(ele , maxi) ;
        } 
        int[] line = new int[maxi+k+2];
        for(int ele : nums){
            int val = (ele-k)<0?0:ele-k;
            line[val]++;
            line[ele+k+1]--;
        }
        int ans =-1;
        for(int i=1;i<line.length;i++){
            line[i]+=line[i-1];
            int frequency = freq.getOrDefault(i, 0);
            ans = Math.max(ans ,frequency+Math.min(line[i]-frequency ,numOperations));
        }
        return ans;
    }
}
