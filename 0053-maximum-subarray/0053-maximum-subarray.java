class Solution {
    public int maxSubArray(int[] arr) {
        // write your code here
		//Broute Force
		// int n=arr.length;
		// int maxi=Integer.MIN_VALUE;
		// for(int i=0;i<n;i++){
		// 	int sum=0;
		// 	for(int j=i;j<n;j++){
		// 		sum +=arr[j];
		// 		maxi = Math.max(maxi,sum);
		// 	}
		// }
		// return maxi;
        
        //kadane algo
        int n= arr.length;
        int maxsofar=Integer.MIN_VALUE;
        int maxendhere=0;
        for(int i=0;i<n;i++){
            maxendhere+=arr[i];
            if(maxsofar<maxendhere){
                maxsofar=maxendhere;
            }
            if(maxendhere<0){
                maxendhere=0;
            }
        }
        return maxsofar;
    }
}