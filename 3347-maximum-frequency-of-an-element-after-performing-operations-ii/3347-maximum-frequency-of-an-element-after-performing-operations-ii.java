class Solution {
    // public int maxFrequency(int[] nums, int k, int numOperations) {
    //     // MLE since 1 <= nums[i] <= 10^9 & 0 <= k <= 10^9
    //     HashMap<Integer,Integer> freq = new HashMap<>();
    //     int maxi = 0; 
    //     for(int ele : nums){ 
    //         freq.put(ele , freq.getOrDefault(ele,0)+1);
    //         maxi = Math.max(ele , maxi) ;
    //     } 
    //     int[] line = new int[maxi+k+2];
    //     for(int ele : nums){
    //         int val = (ele-k)<0?0:ele-k;
    //         line[val]++;
    //         line[ele+k+1]--;
    //     }
    //     int ans =-1;
    //     for(int i=1;i<line.length;i++){
    //         line[i]+=line[i-1];
    //         int frequency = freq.getOrDefault(i, 0);
    //         ans = Math.max(ans ,frequency+Math.min(line[i]-frequency ,numOperations));
    //     }
    //     return ans;
    // }
    
    public int maxFrequency(int[] nums, int k, int numOperations) {
        HashMap<Integer,Integer> freq = new HashMap<>();
        TreeMap<Integer,Integer> map = new TreeMap<>();
        
        TreeSet<Integer> set = new TreeSet<>();
        for(int ele : nums){
            freq.put(ele , freq.getOrDefault(ele,0)+1);
            map.put(ele-k , map.getOrDefault(ele-k,0)+1);
            map.put(ele+k+1 , map.getOrDefault(ele+k+1,0)-1);
            set.add(ele) ;
            set.add(ele-k) ;
            set.add(ele+k+1);
        }
        int sum =0;
        int ans =-1;
        for(int ele : set){
            //get the curr ele count same :
            sum += map.getOrDefault(ele ,0);
            //do we have same ele present in nums
            int frequency = freq.getOrDefault(ele, 0);
            // present in nums + Min(Currpossible-freq which are made same by using ops  , minops)
            ans = Math.max(ans ,frequency+Math.min(sum-frequency ,numOperations));
        }
        return ans;
    }
}