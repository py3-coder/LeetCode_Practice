class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {
        int n1 =a.length;
        int n2=b.length;
        int n=n1+n2;
        int indx2=n/2;
        int indx1=indx2-1;
        int ele1=-1;
        int ele2=-1;
        int cnt=0;
        int i=0,j=0;

        while(i<n1 && j<n2){
            if(a[i]<b[j]){
                if(cnt==indx1) ele1=a[i];
                if(cnt==indx2) ele2=a[i];
                cnt++;
                i++;
            }else{
                if(cnt==indx1) ele1=b[j];
                if(cnt==indx2) ele2=b[j];
                cnt++;
                j++;
            }
        }
        while(i<n1){
            if(cnt==indx1) ele1=a[i];
            if(cnt==indx2) ele2=a[i];
            cnt++;
            i++;
        }
        while(j<n2){
            if(cnt==indx1) ele1=b[j];
            if(cnt==indx2) ele2=b[j];
            cnt++;
            j++;
        }
        
        if (n % 2 == 1) {
            return (double)ele2;
        }
        return (double)((double)(ele1 + ele2)) / 2.0;
    }
}