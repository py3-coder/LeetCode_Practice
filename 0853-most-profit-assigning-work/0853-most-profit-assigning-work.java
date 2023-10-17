class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
       PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> b[1]-a[1]); 
       for(int i=0;i<difficulty.length;i++){
           pq.add(new int[]{difficulty[i],profit[i]});
       }
       Arrays.sort(worker);
       int sum=0;
       for(int i=worker.length-1;i>=0 && !pq.isEmpty();i--){
           if(worker[i]>=pq.peek()[0]){
               sum+=pq.peek()[1];
           }else{
               while(!pq.isEmpty() && worker[i]<pq.peek()[0]){
                   pq.poll();
               }
               if(!pq.isEmpty()){
                   sum+=pq.peek()[1];
               }
           }
       }
       return sum;
        
    }
    public static int BS(int[] arr,int target){
        int low=0;
        int high =arr.length-1;

        while(low<=high){
            int mid =low+(high-low)/2;
            if(arr[mid]==target){
                return mid;
            }else if(arr[mid]>target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return high;
    }
}