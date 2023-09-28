class Solution {
    public int sumSubarrayMins(int[] arr) {
        //Broute Force :: 
        // TC :O(n^2) 
        // SC : O(1)
        long mod = (long)1000000007;;
        //Lets Implement Using Stack::
        int n=arr.length;
        int left[] =new int[n];
        int right[] = new int[n];

        Stack<Integer> st =new Stack<>();
        for(int i=0;i<n;i++){
            if(st.isEmpty()){
                left[i] =i+1;
            }else if(arr[st.peek()]<arr[i]){
                left[i] =i-st.peek();
            }else{
                while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                    st.pop();
                }
                if(st.isEmpty()){
                    left[i] =i+1;
                }else{
                    left[i]=i-st.peek();
                }
                
            }
            st.push(i);
        }
        st.clear();
        for(int i=n-1;i>=0;i--){
            if(st.isEmpty()){
                right[i] =n-i;
            }else if(arr[st.peek()]<arr[i]){
                right[i] =st.peek()-i;
            }else{
                while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                    st.pop();
                }
                if(st.isEmpty()){
                    right[i]=n-i;
                }else{
                    right[i]=st.peek()-i;
                }
            }
            st.push(i);
        }

        int res=0;
        for(int i=0;i<n;i++){
            long temp=((long)arr[i]*left[i]*right[i])%mod;
            res+=temp;
            res%=mod;
        }
        return res;

    }
}