class Solution {
//    public long continuousSubarrays(int[] nums) {
        //Broute Force  ~ TLE bcx  10^5 * 10^ 5 = 10^10 >>> 10^8 :
        // TC - O(n^2)
        // SC - O(1)
        
        //int n = nums.length;
        // Optimise :
//         PriorityQueue<Long> pq = new PriorityQueue<>((a,b)->(b,a));
//         pq.offer(nums[0]);
//         int min=nums[0],max=nums[0];
//         int start=0,end=1;
//         while(end<n){
//             pq.offer(nums[end]);
//             if(min>nums[end]){
//                 min=nums[end];
//             }
//             max =pq.peek();
//             if(max-min<=2){
//                 res+=end-start+1;
//             }else{
//                 while(pq.peek()-min<=2){
//                     pq.poll();
//                     start++;
//                 }
                
//             }
//             end++;
//         }
        
        
        
//         long res=0;
//         int min=0,max=0;
//         for(int i=0;i<n;i++){
//             max = min = nums[i];
//             for(int j=i+1;j<n;j++){
//                 //min
//                 if(nums[j]<min){
//                     min = nums[j];
//                 }
//                 //max 
//                 if(nums[j]>max){
//                     max = nums[j];
//                 }
                
//                 if(Math.abs(max-min)<=2){
//                     int len =j-i+1;
//                     res++;
//                 }else {
//                     break;
//                 }
//             }
//         }

//        return res+n;
        
//     }
    
    public long continuousSubarrays(int[] nums) {
        long ans = 0;
        int n = nums.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int start=0,end=0;
        while(end<n)
        {
            map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);

            while (map.size() > 1 && map.lastKey() - map.firstKey() > 2) 
            {
                map.put(nums[start], map.get(nums[start]) - 1);
                if (map.get(nums[start]) == 0) {
                    map.remove(nums[start]);
                }
                start++;
            }

            ans += end - start + 1;
            end++;
        }

        return ans;
    }
}