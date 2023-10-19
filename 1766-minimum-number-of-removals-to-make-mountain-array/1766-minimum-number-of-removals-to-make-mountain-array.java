class Solution {
    public int minimumMountainRemovals(int[] nums) {
        // Explanation:: LIS ::
        //Since we need to find the no. of deletion to make mountain array::
        // So if we apply LIS from front and back  add the max value and reduce -1:
        // Eg : [2,1,1,5,6,2,3,1]
        // front:1,1,1,2,3,2,3,1
        // back :2,1,1,3,4,2,2,1
        //------------------------
        //               7-1 =6 :
        // that is the length of mountain array so simple find size of mountain array 
        // return total len-mountain : no. of deletion:


        //*IMP :: Point If we have Increasing party only and decreasing part only
        // not valid one::
        // since when ever we have lis==1 && lds ==1 we can skip it..
        //

        return solveLIS(nums);


    }
    public static int solveLIS(int[] arr){
        int n=arr.length;
        int flis[] =new int[n];
        int blis[] =new int[n];
        Arrays.fill(flis,1);
        Arrays.fill(blis,1);

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j] && 1+flis[j]>flis[i]){
                    flis[i]=1+flis[j];
                }
            }
        }
        int maxi=0;
        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>i;j--){
                if(arr[i]>arr[j] && 1+blis[j]>blis[i]){
                    blis[i]=1+blis[j];
                }
            }
            if(flis[i]>1 && blis[i]>1){
                maxi =Math.max(maxi,flis[i]+blis[i]-1);
            }
            
        }
        return n-maxi;
    }
}