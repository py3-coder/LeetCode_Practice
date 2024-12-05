class Solution {
//     public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
//         int n = nums.size();
//         if(n<2*k) return false;
//         if(k==1) return true;
//         for(int i=0;i<n-2*k+1;i++){
//            if(check(i,k,nums)==true){
//                return true;
//            }
//         }
//         return false;
//     }
//     public boolean check(int i , int k , List<Integer> nums){
//         int n = nums.size();
//         for(int j=i;j<i+2*k-1 && j<n-1 ;j++){
//                 int curr = nums.get(j) , next = nums.get(j+1);
//                 if(curr >=next && j!=i+k-1){
//                     return false;
//                 }
//                 if(j == i+k-1){
//                     continue;
//                 }
//             }
//         return true;
//     }
//     public boolean hasIncreasingSubarrays(int[] nums, int k) {
//         int n = nums.length;
//         if (n / k < 2) return false;
//         if (k == 1) return true;

//         int[] vis = new int[n];
//         int start = 0, end = 1;

//         while (end < n) {
//             while (end < n && nums[end] > nums[end - 1]) {
//                 if (end - start + 1 == k) {
//                     vis[start] = 1;
//                     start++;
//                 }
//                 end++;
//             }
//             start = end;
//             end++;
//         }

//         for (int i = 0; i <= n - (2 * k); i++) {
//             if (vis[i] == 1 && vis[i + k] == 1) return true;
//         }
//         return false;
//     }
     public boolean hasIncreasingSubarrays(List<Integer> nums,int k) {
        int res = 0; int prev = 0; int curr = 1;
        for(int i = 1; i<nums.size(); i++){
            if(nums.get(i) > nums.get(i-1)){
                curr++;
            }else{
                prev = curr;
                curr = 1;
            }
            res = Math.max(res , Math.max(curr/2 , Math.min(prev , curr)));
        }
        return res>=k;
    }
}