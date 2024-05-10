class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        // TC ~ O(n^2logn)
        // SC ~ O(n)
        
        
        // TC ~ O(max(n,k)logn)
        // SC ~ O(n)
        
        
//         PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(arr[a[0]]*arr[b[1]]-arr[a[1]]*arr[b[0]]));
//         for(int i=0;i<arr.length-1;i++){
//             pq.offer(new int[]{i,arr.length-1});
//         }
        
//         for(int i=0;i<k-1;i++){
//             int[] curr = pq.poll();
            
//             int numindex = curr[0];
//             int denoindex =curr[1];
            
//             if(denoindex-1>numindex){
//                 pq.offer(new int[]{numindex,denoindex-1});
//             }
//          }
        
//        int[] result = pq.poll();
//        return new int[] { arr[result[0]], arr[result[1]] };
        
        
        // BS approch :- Copied -
        // TC :O(n*C) C <= 31
       int n = arr.length, min = arr[0], max = arr[n-1], p=0, q=0;
        double lo = (double)min/(double)max, hi = 1.0;
        while (lo < hi) {
            double mid = (lo + hi) / 2.0;
            int[] count = countPairs(arr, mid);
            if (count[0] == k) {
                p = count[1];
                q = count[2];
                break;
            }
            if (count[0] < k) lo = mid;
            else hi = mid;
        }
        return new int[] {p, q};
            
    }
    private int[] countPairs(int[] A, double x) {
        //p and q are used for storing the indices of max fraction
        //cnt of value in indx term
        int count = 0, n = A.length, p = 0, q = 0;
        double max = 0.0;
        //max is used to store the maximum fraction less than mid
        for (int i = 0, j = 0; i < n; i++) {
            while (j < i && A[j] < A[i] * x) j++;
            if (j > 0) {
                double fraction = (double)A[j-1] / (double)A[i];
                if (max < fraction) {
                    max = fraction;
                    p = A[j-1];
                    q = A[i];
                }
            }
            count += j;
        }
        return new int[] {count, p, q};
    }
}