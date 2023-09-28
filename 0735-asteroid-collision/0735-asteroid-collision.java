class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        //lets Play with Stack::
        Stack<Integer> st =new Stack<>();
        for(int val:asteroids){
            if(st.isEmpty() || val>0){
                st.push(val);
            }else{
                while(!st.isEmpty() && st.peek()>0 && Math.abs(val)>st.peek()){
                    st.pop();
                }
                if(!st.isEmpty() && (-st.peek()==val || st.peek()==-val)){
                    st.pop();
                }
                else if(st.isEmpty() || (!st.isEmpty() && st.peek()<0 && val<0)){
                    st.push(val);
                }

            }
        }
        int[] res =new int[st.size()];
        int k=st.size()-1;
        while(!st.isEmpty()){
            res[k--] =st.pop();
        }
        return res;
    }
}