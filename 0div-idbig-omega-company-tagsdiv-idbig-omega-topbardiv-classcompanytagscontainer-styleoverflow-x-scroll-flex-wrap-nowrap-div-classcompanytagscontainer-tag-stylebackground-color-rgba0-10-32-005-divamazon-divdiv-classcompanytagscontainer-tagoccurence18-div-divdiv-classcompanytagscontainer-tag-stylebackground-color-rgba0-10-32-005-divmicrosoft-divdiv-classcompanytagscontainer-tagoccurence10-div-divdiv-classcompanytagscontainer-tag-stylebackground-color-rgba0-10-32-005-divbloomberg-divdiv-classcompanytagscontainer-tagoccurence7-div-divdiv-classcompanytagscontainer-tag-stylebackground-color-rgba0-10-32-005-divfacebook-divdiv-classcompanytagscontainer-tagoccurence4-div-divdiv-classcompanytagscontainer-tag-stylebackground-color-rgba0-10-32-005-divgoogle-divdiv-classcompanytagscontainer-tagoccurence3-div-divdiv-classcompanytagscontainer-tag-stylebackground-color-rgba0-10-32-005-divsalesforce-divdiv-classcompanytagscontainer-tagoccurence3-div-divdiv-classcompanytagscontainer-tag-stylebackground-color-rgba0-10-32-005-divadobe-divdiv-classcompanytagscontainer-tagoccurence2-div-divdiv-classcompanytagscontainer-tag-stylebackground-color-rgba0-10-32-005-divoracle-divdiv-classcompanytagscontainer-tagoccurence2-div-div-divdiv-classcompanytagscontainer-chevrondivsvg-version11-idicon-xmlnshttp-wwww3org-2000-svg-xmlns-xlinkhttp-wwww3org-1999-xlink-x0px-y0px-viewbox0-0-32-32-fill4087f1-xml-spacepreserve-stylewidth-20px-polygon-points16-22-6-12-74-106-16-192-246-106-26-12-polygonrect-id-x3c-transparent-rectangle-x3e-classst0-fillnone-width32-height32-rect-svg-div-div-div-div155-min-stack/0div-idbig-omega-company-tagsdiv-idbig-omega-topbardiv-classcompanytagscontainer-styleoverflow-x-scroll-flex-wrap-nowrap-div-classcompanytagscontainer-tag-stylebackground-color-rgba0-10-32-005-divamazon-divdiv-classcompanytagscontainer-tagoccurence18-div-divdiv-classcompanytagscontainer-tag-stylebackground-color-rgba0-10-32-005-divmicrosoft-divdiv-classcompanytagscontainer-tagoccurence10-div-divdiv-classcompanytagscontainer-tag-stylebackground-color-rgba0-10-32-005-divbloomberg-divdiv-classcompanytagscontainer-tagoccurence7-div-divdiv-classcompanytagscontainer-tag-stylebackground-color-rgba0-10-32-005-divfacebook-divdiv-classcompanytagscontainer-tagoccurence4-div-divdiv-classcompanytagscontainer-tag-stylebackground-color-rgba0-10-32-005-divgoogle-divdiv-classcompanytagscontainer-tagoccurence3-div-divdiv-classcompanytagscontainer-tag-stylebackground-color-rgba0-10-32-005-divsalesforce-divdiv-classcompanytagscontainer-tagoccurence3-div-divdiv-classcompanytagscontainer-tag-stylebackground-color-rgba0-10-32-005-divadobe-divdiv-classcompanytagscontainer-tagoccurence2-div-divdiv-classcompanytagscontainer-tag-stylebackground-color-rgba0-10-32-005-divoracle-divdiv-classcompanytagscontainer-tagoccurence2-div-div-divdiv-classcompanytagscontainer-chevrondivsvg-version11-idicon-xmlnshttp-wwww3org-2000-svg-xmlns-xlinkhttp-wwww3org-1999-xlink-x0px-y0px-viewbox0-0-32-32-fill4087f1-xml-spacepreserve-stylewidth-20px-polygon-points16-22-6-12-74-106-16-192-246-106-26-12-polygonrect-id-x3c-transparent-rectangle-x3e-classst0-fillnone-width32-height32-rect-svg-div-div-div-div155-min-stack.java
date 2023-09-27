class MinStack {
    Stack<Integer> st;
    Stack<Integer> mini;
    public MinStack() {
        st=new Stack<>();
        mini=new Stack<>();
    }
    
    public void push(int val) {
        if(mini.isEmpty() || mini.peek()>val){
            mini.push(val);
        }else{
            mini.push(mini.peek());
        }
        st.push(val);
         
    }
    
    public void pop() {
        if(st.isEmpty()){
            return ;
        }
        st.pop();
        mini.pop();
    }
    
    public int top() {
        if(st.isEmpty()){
            return -1;
        }
        return st.peek();
    }
    
    public int getMin() {
        if(st.isEmpty()){
            return -1;
        }
        return mini.peek();
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