class MyCalendarThree {

    TreeMap<Integer,Integer> map;
    public MyCalendarThree() {
        map = new TreeMap<>();
    }
    
    public int book(int start, int end) {
         //sweep line algo:-
        map.put(start , map.getOrDefault(start,0)+1);
        map.put(end , map.getOrDefault(end,0)-1);
        
        int sum=0;
        int maxi =0;
        for(Map.Entry<Integer,Integer> itr : map.entrySet()){
            sum+=itr.getValue();
            maxi = Math.max(maxi,sum);
        }
        return maxi;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */