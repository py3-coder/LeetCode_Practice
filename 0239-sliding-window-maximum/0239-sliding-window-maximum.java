class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int n=arr.length;
        if(n==1){
            return new int[]{arr[0]};
        }
        int[] res = new int[n-k+1];
        Deque<Integer> deque = new ArrayDeque<>();
        int p=0;
        int i=0,j=0;
        while(j<n){
            //remove all those who are lesser than current::
            while(deque.size()>0 && deque.getLast()<arr[j]){
                deque.removeLast();
            }
            //add at last
            deque.offer(arr[j]);
            //window size is lesss so j++;
            if(j-i+1<k) j++;
            else if(j-i+1==k){
                //the first ele will be max for that window
                res[p++]=deque.getFirst();
                if(arr[i]==deque.getFirst()){
                    deque.removeFirst();
                }
                i++;
                j++;
            }
            
        }
        
        return res;
    }
}