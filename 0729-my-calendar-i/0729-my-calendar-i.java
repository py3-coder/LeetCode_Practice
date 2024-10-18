class MyCalendar {

    TreeMap<Integer, Integer> map;

    public MyCalendar() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
//         Integer floorKey = calendar.floorKey(start);
//         System.out.println(floorKey);
//         if (floorKey != null && calendar.get(floorKey) > start) return false;
//         Integer ceilingKey = calendar.ceilingKey(start);
//         if (ceilingKey != null && ceilingKey < end) return false;

//         calendar.put(start, end);
//         return true;
        
        
        // sweep line algo ::
        map.put(start, map.getOrDefault(start,0)+1);
        map.put(end, map.getOrDefault(end,0)-1);
        int sum=0;
        for(Map.Entry<Integer,Integer> itr :map.entrySet()){
            sum += itr.getValue();
            
            if(sum>1){
                map.put(start, map.get(start)-1);
                map.put(end, map.get(end)+1);
                
                return false;
            }
        }
        
        return true;
        
        
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */