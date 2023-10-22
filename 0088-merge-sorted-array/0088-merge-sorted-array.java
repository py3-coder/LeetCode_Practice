class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int right=nums1.length-1;
        int left =m-1;
        int k =n-1;
        while(k>=0){
            if(left>=0 && nums1[left]>nums2[k]){
                nums1[right] =nums1[left];
                left--;
                right--;
            }else{
                nums1[right] =nums2[k];
                right--;
                k--;
            }
        }
    }
}