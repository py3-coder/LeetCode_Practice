class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int n=arr.length;
        if(n==1){
            return new int[]{arr[0]};
        }
        int[] res = new int[n-k+1];
        List<Integer> lis=new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        int p=0;
        int i=0,j=0;
        while(j<n){
            while(deque.size()>0 && deque.getLast()<arr[j]){
                deque.removeLast();
            }
            deque.offer(arr[j]);
            
            if(j-i+1<k) j++;
            
            else if(j-i+1==k){
                lis.add(deque.getFirst());
                if(arr[i]==deque.getFirst()){
                    deque.removeFirst();
                }
                i++;
                j++;
            }
            
        }
        for(int val :lis){
            res[p++]=val;
        }
        return res;
    }
}