class Solution {
    public int maxProduct(int[] arr) {
        int n = arr.length;

        //Broute Force ::
        // TC : O(n^2)
        //SC : O(1)


        int prod=1;
        int maxi =Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            prod*=arr[i];
            maxi=Math.max(prod,maxi);
            if(prod==0){
                prod=1;
            }
            
        }
        prod=1;
        for(int i=n-1;i>=0;i--){
            prod*=arr[i];
            maxi=Math.max(prod,maxi);
            if(prod==0){
                prod=1;
            }
            
        }
        return maxi;
        




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
    }
}
