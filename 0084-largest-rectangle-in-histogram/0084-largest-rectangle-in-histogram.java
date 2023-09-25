class Solution {
    public int largestRectangleArea(int[] arr) {
        int[] right=new int[arr.length];
        int[] left = new int[arr.length];
        Stack<Integer> st = new Stack();
        //NSR , NSL ::
        for(int i=arr.length-1;i>=0;i--){
            if(st.isEmpty()){
                right[i] =arr.length;
            }else if(arr[st.peek()]<arr[i]){
                right[i] =st.peek();
            }else{
                while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                    st.pop();
                }
                if(st.isEmpty()){
                    right[i] =arr.length;
                }else{
                    right[i] =st.peek();
                }
            }
            st.push(i);
        }
        st.clear();
        for(int i=0;i<arr.length;i++){
            if(st.isEmpty()){
                left[i] =-1;
            }else if(arr[st.peek()]<arr[i]){
                left[i] =st.peek();
            }else{
                while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                    st.pop();
                }
                if(st.isEmpty()){
                    left[i] =-1;
                }else{
                    left[i] =st.peek();
                }
            }
            st.push(i);
        }
       
        int width=0;
        int maxi=0;
        for(int i=0;i<arr.length;i++){
            width =right[i]-left[i]-1;
            maxi =Math.max(width*arr[i],maxi);
        }
        return maxi;
    }
}