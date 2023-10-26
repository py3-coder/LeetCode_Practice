class MinStack {
    //Approch Using 2 stack will maintain a stack for min ele::
    // TC: O(1)  SC: O(2n)
    Stack<Integer> st;
    Stack<Integer> mini;
    public MinStack() {
        st =new Stack<>();
        mini=new Stack<>();
    }
    
    public void push(int val) {
        if(st.isEmpty() || mini.peek()>=val){
            st.push(val);
            mini.push(val);
        }else{
            st.push(val);
        }
    }
    
    public void pop() {
        int a =st.peek();
        int b=mini.peek();
        if(a==b){
            st.pop();
            mini.pop();
        }else{
            st.pop();
        }
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        if(!mini.isEmpty()){
            return mini.peek();
        }else{
            return -1;
        }
        
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