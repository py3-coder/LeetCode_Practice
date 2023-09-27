class MinStack {
    Stack<Long> st;
    Long mini;
    //Stack<Integer> mini;
    public MinStack() {
        st=new Stack<>();
        mini =Long.MAX_VALUE;
        //mini=new Stack<>();
    }
    
    public void push(int vl) {
        Long val= Long.valueOf(vl);
        if(st.isEmpty()){
            st.push(val);
            mini=val;
        }else{
            if(val<mini){
                st.push(2*val-mini);
                mini=val;
            }else{
                st.push(val);
            }
            
        }
        
         
    }
    
    public void pop() {
        if(st.isEmpty()){
            return ;
        }
        Long val =st.pop();
        if(val<mini){
            mini =2*mini-val;
        }
    }
    
    public int top() {
        if(st.isEmpty()){
            return -1;
        }
        Long val =st.peek();
        if(val<mini){
            return mini.intValue();
        }
        return val.intValue();
    }
    
    public int getMin() {
        return mini.intValue();
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