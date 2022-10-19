class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        Map<String ,Integer>  map = new HashMap<>();
        for(String word : words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        //Priority Queue with custom comperator using lembda exp:
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
        (a,b)-> a.getValue()==b.getValue()?b.getKey().compareTo(a.getKey()):a.getValue()-b.getValue());
        
        for(Map.Entry<String,Integer> entry :map.entrySet()){
            pq.offer(entry);
            if(pq.size()>k){
                pq.poll();
            }
        }
        while(!pq.isEmpty()){
            res.add(0,pq.poll().getKey());
        }
        return res;
    }
}