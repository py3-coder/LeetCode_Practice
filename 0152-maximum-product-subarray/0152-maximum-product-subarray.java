class Solution {
    public int maxProduct(int[] arr) {
        int n = arr.length;

        //Broute Force ::
        // TC : O(n^2)
        //SC : O(1)


        //Improvoised Kadane::
        // int prod=1;
        // int maxi =Integer.MIN_VALUE;
        // for(int i=0;i<n;i++){
        //     prod*=arr[i];
        //     maxi=Math.max(prod,maxi);
        //     if(prod==0){
        //         prod=1;
        //     }
            
        // }
        // prod=1;
        // for(int i=n-1;i>=0;i--){
        //     prod*=arr[i];
        //     maxi=Math.max(prod,maxi);
        //     if(prod==0){
        //         prod=1;
        //     }
            
        // }
        // return maxi;

        //TC : O(n)+O(n)
        //SC : O(1)
        
        // int maxi =Integer.MIN_VALUE;
        // //Based on Some Observation 
        // int prefix=1;
        // int suffix=1;
        // for(int i=0;i<n;i++){
        //     prefix*=arr[i];
        //     suffix*=arr[n-i-1];
        //     maxi =Math.max(maxi,Math.max(prefix,suffix));
        //     if(prefix==0) prefix=1;
        //     if(suffix==0) suffix=1;
            
        // }
        // return maxi;

        //TC : O(n)
        //SC : O(1)

        //Lets Deep Dive to kadance again with optimal approch ::::

        int ans=arr[0];
        int currMax =arr[0];
        int currMin =arr[0];
        for(int i=1;i<n;i++){
            int temp=currMax;
            currMax =Math.max(temp*arr[i],Math.max(currMin*arr[i],arr[i]));
            currMin =Math.min(temp*arr[i],Math.min(currMin*arr[i],arr[i]));
            
            ans =Math.max(ans,currMax);
        }
        return ans;
    }
}
