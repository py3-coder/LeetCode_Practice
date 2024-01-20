class Solution {
    
    public int sumSubarrayMins(int[] arr) {
        //Broute Force ::
        // TC: O(n^2) SC: O(1);;
        // Approch : i loop and take j loop iterate over it:) from 0 to i
        // J loop depends on i::) Stack Can helps us to optimised:)
        long mod = (long)1000000007;
        int n=arr.length;
        int nsl[] = new int[n];
        int nsr[] =new int[n];
        Stack<Integer> st = new Stack<>();
        // nsl
        for(int i=0;i<n;i++){
            if(st.isEmpty()){
                nsl[i] = i+1;
            }else if(arr[st.peek()]<arr[i]){
                nsl[i] =i-st.peek();
            }else {
                while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                    st.pop();
                }
                if(st.isEmpty()){
                    nsl[i]=i+1;
                }else{
                    nsl[i] =i-st.peek();
                }
            }
            st.push(i);
        }

        st.clear();
        //nsr::
        for(int i=n-1;i>=0;i--){
            if(st.isEmpty()){
                nsr[i] = n-i;
            }else if(arr[st.peek()]<arr[i]){
                nsr[i]=st.peek()-i;
            }else{
                while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                    st.pop();
                }
                if(st.isEmpty()){
                    nsr[i]=n-i;
                }else{
                    nsr[i]=st.peek()-i;
                }
            }
            st.push(i);
        }

        int res=0;
        for(int i=0;i<n;i++){
            //System.out.println(nsl[i]+" "+nsr[i]);
            long ans=((long)arr[i]*nsl[i]*nsr[i])%mod;
            res+=ans;
            res%=mod;
        }
        return res;
        
    }
}
