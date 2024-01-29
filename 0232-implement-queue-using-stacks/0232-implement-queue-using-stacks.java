class MyQueue {
    Stack<Integer> in =new Stack<>();
    Stack<Integer> out = new Stack<>();
    public MyQueue() {
        
    }
    
    public void push(int x) {
        in.push(x);
    }
    
    public int pop() {
        if(out.isEmpty() && in.isEmpty()){
            return -1;
        }
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.pop();
    }
    
    public int peek() {
        if(out.isEmpty() && in.isEmpty()){
            return -1;
        }
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.peek();
        
    }
    
    public boolean empty() {
        return out.isEmpty() && in.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */