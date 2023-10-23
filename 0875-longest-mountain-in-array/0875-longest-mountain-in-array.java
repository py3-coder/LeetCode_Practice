class Solution {
    public int longestMountain(int[] arr) {
        //LIS Pattern Problem::
        // Arrays ::)
        //edge case ::
        if(arr.length<3){
            return 0;
        }
        return solveLIS(arr);
    }
    public static int solveLIS(int[] arr){
        int n=arr.length;
        int lis[] = new int[n];
        int lds[] =new int[n];
        Arrays.fill(lis,1);
        Arrays.fill(lds,1);

        for(int i=1;i<n;i++){
            if(arr[i]>arr[i-1]){
                lis[i] =Math.max(lis[i],1+lis[i-1]);
            }
        }
        for(int i=n-2;i>=0;i--){
            if(arr[i]>arr[i+1]){
                lds[i] =Math.max(lds[i],1+lds[i+1]);
            }
        }
        int ans=0;
        for(int i=0;i<n;i++){
            if(lis[i]>1 && lds[i]>1){
                ans =Math.max(ans,lis[i]+lds[i]-1);
            }
        }
        return ans;
    }
    

}