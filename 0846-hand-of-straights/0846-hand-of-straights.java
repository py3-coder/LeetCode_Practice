class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        //Edge Case::::
       if(hand.length%groupSize!=0) return false;
       //Store the Freq:::
       HashMap<Integer,Integer> map =new HashMap<>();
       for(int ele:hand){
           map.put(ele,map.getOrDefault(ele,0)+1);
       }
       PriorityQueue<Integer> minheap =new PriorityQueue<>();
       for(int val :map.keySet()){
           minheap.add(val);
       }
       int k=hand.length/groupSize;
       while(k>0){
            int curr =minheap.peek();
            while(!map.containsKey(curr)){
                minheap.poll();
                curr =minheap.peek();
            }
            int min  =curr;
            int p=groupSize;
            while(p>0){
               if(map.containsKey(min)){
                   if(map.get(min)==1){
                       if(min==curr){
                           minheap.poll();
                       }
                       map.remove(min);
                   }else{
                       map.put(min,map.get(min)-1);
                   }
                   min=min+1;
               }else{
                   return false;
               }
               p--;
           }
           k--;
       }
       return true;

    }
}