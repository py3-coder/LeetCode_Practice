class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length;
        int total = Arrays.stream(nums).sum();
        int N = n/2;
        
        // Meet in Middle Concept :: - we can use map also :
        List<List<Integer>> left = new ArrayList<>();
        List<List<Integer>> right = new ArrayList<>();
        
        
        for(int i=0;i<=N;i++){
            left.add(new ArrayList<>());
            right.add(new ArrayList<>());
        }
        
        // let generate all subset 0-N -left & N+1 -n -right
        // total no. of subset -- 2^n ---: left - 2^N
        for(int i=0;i<(1<<N);i++){
            int setbit=0;
            int sum=0;
            // check every bits 
            for(int j=0;j<N;j++){
                // if it set means - we gona pick that ele:
                if((i & (1<<j))!=0){
                    setbit++;
                    sum+=nums[j];
                }
            }
            left.get(setbit).add(sum);
        }
        
        
        //right half :
        for(int i=0;i<(1<<N);i++){
            int setbit=0;
            int sum=0;
            // check every bits 
            for(int j=0;j<N;j++){
                // if it set means - we gona pick that ele:
                if((i & (1<<j))!=0){
                    setbit++;
                    sum+=nums[j+N];
                }
            }
            right.get(setbit).add(sum);
        }
        
        int ans = Integer.MAX_VALUE;
        
        for(int i=0;i<=N;i++){
            List<Integer> l = left.get(i);
            List<Integer> r = right.get(N-i);
            
            Collections.sort(l);
            Collections.sort(r);
            int a =0,b=r.size()-1;
            while(a<l.size() && b>=0){
               int currsum = l.get(a) + r.get(b);
               int diff = Math.abs(total - 2*currsum);
                ans = Math.min(ans,diff);
                if(2*currsum > total )b--;
                else a++;
            }
            
        }
        
        return ans;
    }
}
// class Solution {
//     public int minimumDifference(int[] nums) {
//         int n = nums.length;
//         int total = Arrays.stream(nums).sum();
//         int N = n/2;
        
//         // Meet in Middle Concept :: - we can use map also :
//         Map<Integer, List<Integer>> mp1 = new HashMap();
//         Map<Integer, List<Integer>> mp2 = new HashMap();
        
        
//         // for(int i=0;i<=N;i++){
//         //     left.add(new ArrayList<>());
//         //     right.add(new ArrayList<>());
//         // }
        
//         // let generate all subset 0-N -left & N+1 -n -right
//         // total no. of subset -- 2^n ---: left - 2^N
//         for(int i=0;i<(1<<N);i++){
//             int setbit=0;
//             int sum=0;
//             // check every bits 
//             for(int j=0;j<N;j++){
//                 // if it set means - we gona pick that ele:
//                 if((i & (1<<j))!=0){
//                     setbit++;
//                     sum+=nums[j];
//                 }
//             }
//             if(!mp1.containsKey(setbit)){
//                 mp1.put(setbit,new ArrayList());
//             }
//             mp1.get(setbit).add(sum);
//         }
        
        
//         //right half :
//         for(int i=0;i<(1<<N);i++){
//             int setbit=0;
//             int sum=0;
//             // check every bits 
//             for(int j=0;j<N;j++){
//                 // if it set means - we gona pick that ele:
//                 if((i & (1<<j))!=0){
//                     setbit++;
//                     sum+=nums[j+N];
//                 }
//             }
//             if(!mp2.containsKey(setbit)){
//                 mp2.put(setbit,new ArrayList());
//             }
//             mp2.get(setbit).add(sum);
//         }
        
        
//          for(int i=0;i<=n;i++){
//             if(mp1.containsKey(i)){
//                 Collections.sort(mp1.get(i));
//             }
            
//             if(mp2.containsKey(i)){
//                 Collections.sort(mp2.get(i));
//             }
//         }

//         int ans = Integer.MAX_VALUE;
//         for(int i=0;i<=N;i++){
//             int a = 0, b=mp2.get(N-i).size()-1;
//             while(a < mp1.get(i).size() && b>=0){
//                 int sum = mp1.get(i).get(a) + mp2.get(N-i).get(b);
//                 int diff = Math.abs(total - 2*sum);
//                 ans = Math.min(ans,diff);
//                 if(2*sum > total )b--;
//                 else a++;
//             }
//         }
        
//         return ans;
//     }
// }