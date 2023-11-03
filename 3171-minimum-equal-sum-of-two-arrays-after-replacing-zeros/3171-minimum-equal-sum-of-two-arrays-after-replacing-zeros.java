class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0;
        int zeroes1 = 0;
        for (int num : nums1) {
            if (num == 0) {
                zeroes1++;
            }
            sum1 += num;
        }
        long sum2 = 0;
        int zeroes2 = 0;
        for (int num : nums2) {
            if (num == 0) {
                zeroes2++;
            }
            sum2 += num;
        }

        if (sum1 + zeroes1 < sum2 + zeroes2) {
            long temp = sum1;
            int temp2= zeroes1;
            sum1 = sum2;
            sum2 = temp;
            temp = zeroes1;
            zeroes1 = zeroes2;
            zeroes2 = temp2;
        }

        if (sum1 + zeroes1 > sum2 && zeroes2 == 0) {
            return -1;
        }

        return sum1 + zeroes1;
    }
}