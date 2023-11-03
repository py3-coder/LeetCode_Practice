class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long s1 = 0;
        int z1 = 0;
        for (int num : nums1) {
            if (num == 0) z1++;
            s1 += num;
        }
        long s2 = 0;
        int z2 = 0;
        for (int num : nums2) {
            if (num == 0) z2++;
            s2 += num;
        }
        long ans=-1;
        if(z1!=0 && z2!=0) ans= Math.max(s1+z1,s2+z2);
        else if(z1==0 && z2!=0 && s1>=s2+z2) ans=s1;
        else if(z1!=0 && z2==0 && s2>=s1+z1) ans=s2;
        else if(z1==0 && z2==0 && s1==s2) ans=s1;
        return ans;
    }
}