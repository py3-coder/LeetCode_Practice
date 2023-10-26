class MinStack {
    Stack<Long> st;
    Long min;
    public MinStack() {
        st =new Stack<>();
        min=Long.MAX_VALUE;
    }
    
    public void push(int vl) {
        Long val =Long.valueOf(vl);
        if(st.isEmpty()){
            st.push(val);
            min=val;
        }else{
            if(min>val){
                st.push(2*val-min);
                min =val;
            }else{
                st.push(val);
            }
        }
        
    }
    
    public void pop() {
        long val =st.pop();
        if(val<min){
            min=2*min-val;
        }
        
    }
    
    public int top() {
        Long val = st.peek();
        if(val<min){
            return min.intValue();
        }
        return val.intValue();   
    }
    
    public int getMin() {
        return  min.intValue();
    }
}


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */