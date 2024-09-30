class CustomStack {
    
    private int[] arr;
    private int   curr = -1;

    public CustomStack(int maxSize) {
        this.arr = new int[maxSize];
    }
    
    public void push(int x) {
        if (curr+1 < arr.length) {
            arr[++curr] = x;
        }
    }
    
    public int pop() {
        return curr < 0 ? curr : arr[curr--];
    }
    
    public void increment(int k, int val) {
        for (int i = 0; i < Math.min(k, curr+1); i++) {
            arr[i] += val;
        }
    }
}


/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */