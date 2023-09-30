class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {
        int n1 =a.length;
        int n2=b.length;
        //Broute Force  ::
        //TC : O(n+m)
        //SC : O(n+m)


        //Optimised ::
        //TC : O(n+m)
        //SC :O(1)
        
        // int n=n1+n2;
        // int indx2=n/2;
        // int indx1=indx2-1;
        // int ele1=-1;
        // int ele2=-1;
        // int cnt=0;
        // int i=0,j=0;

        // while(i<n1 && j<n2){
        //     if(a[i]<b[j]){
        //         if(cnt==indx1) ele1=a[i];
        //         if(cnt==indx2) ele2=a[i];
        //         cnt++;
        //         i++;
        //     }else{
        //         if(cnt==indx1) ele1=b[j];
        //         if(cnt==indx2) ele2=b[j];
        //         cnt++;
        //         j++;
        //     }
        // }
        // while(i<n1){
        //     if(cnt==indx1) ele1=a[i];
        //     if(cnt==indx2) ele2=a[i];
        //     cnt++;
        //     i++;
        // }
        // while(j<n2){
        //     if(cnt==indx1) ele1=b[j];
        //     if(cnt==indx2) ele2=b[j];
        //     cnt++;
        //     j++;
        // }
        
        // if (n % 2 == 1) {
        //     return (double)ele2;
        // }
        // return (double)((double)(ele1 + ele2)) / 2.0;

        //Best Approch Apply Binary Search ::
        //Always apply Bs on Smaller array:
        if(n1>n2) return findMedianSortedArrays(b,a);
        int n = n1+n2;
        int left = (n1+n2+1)/2;

        int low =0;
        int high =n1;

        while(low<=high){
            int mid1 = low+(high-low)/2;
            int mid2 = left-mid1;

            int l1 =(mid1>0)?a[mid1-1]:Integer.MIN_VALUE;
            int l2 =(mid2>0)?b[mid2-1]:Integer.MIN_VALUE;
            int r1 =(mid1<n1)?a[mid1]:Integer.MAX_VALUE;
            int r2 =(mid2<n2)?b[mid2]:Integer.MAX_VALUE;
            

            if(l1<=r2 && l2<=r1){
                if(n%2==1){
                    return Math.max(l1,l2);
                }else{
                    return ((double)(Math.max(l1,l2)+Math.min(r1,r2)))/2.0;
                }
            }else if(l1>r2){
                high=mid1-1;
            }else{
                low=mid1+1;
            }
        }
        return 0;
    }
}