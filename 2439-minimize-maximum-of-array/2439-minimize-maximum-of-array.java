class Solution {
    public boolean check(int[] nums, int k) {
        // variable to keep track of how many moves we have
        long have = 0;
        // iterate over the array
        for (int n : nums) {
            // if the number is less than or equal to k, we don't need to do anything
            if (n <= k) {
                // add the number of moves needed to make it k to the total number of moves we have
                have += k - n;
            } else {
                // if the number is greater than k, we need to move some of its value to the previous element
                // check if we have enough moves left to make this move
                if (have < n - k)
                    return false;
                else
                    // if we have enough moves, subtract the number of moves needed to make this move from the total number of moves we have
                    have -= (n - k);
            }
        }
        // if we reach here, it means we were able to achieve a maximum value of k or less using the given number of moves
        return true;
    }

    public int minimizeArrayValue(int[] nums) {
        // initialize left and right pointers for binary search
        int left = 0, right = Arrays.stream(nums).max().getAsInt();
        // perform binary search to find the minimum possible value of the maximum integer of nums after performing any number of operations
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(nums, mid))
                right = mid;
            else
                left = mid + 1;
        }
        // return the minimum possible value of the maximum integer of nums after performing any number of operations
        return left;
    }
}