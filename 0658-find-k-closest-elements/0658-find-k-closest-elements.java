class Solution {
    class Pair{
    int first;
    int sec;
    Pair(int _first,int _sec){
        this.first=_first;
        this.sec=_sec;
       }
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //Lets Play with Heap::
      List<Integer> res = new ArrayList<>();
	    PriorityQueue<Integer> minheap = new PriorityQueue<>((a,b)->{
				if(Math.abs(a-x)==Math.abs(b-x)) return a-b;
				return Math.abs(a-x)-Math.abs(b-x);
			});
	    for(int i=0;i<arr.length;i++){
	        minheap.add(arr[i]);
	    }
	    while(!minheap.isEmpty() && res.size()<k){
	        res.add(minheap.poll());
	    }
			Collections.sort(res);
	    return res;
    }
}