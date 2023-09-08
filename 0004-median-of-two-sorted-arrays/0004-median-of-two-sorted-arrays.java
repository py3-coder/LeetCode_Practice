class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {
        int n=a.length;
        int m=b.length;
        int arr[] = new int[n+m];
        int j=0;
        for(int k=0;k<n;k++){
            arr[j]=a[k];
            j++;
        }
        for(int k=0;k<m;k++){
            arr[j++]=b[k];
        }
        Arrays.sort(arr);
        double median =0;
        if((arr.length)%2!=0){
            median=arr[arr.length/2];
        }else{
            int indx=arr.length/2;
            int sum=arr[indx]+arr[indx-1];
            median=(double)sum/2;
        }
        return (double)median;
    }
}