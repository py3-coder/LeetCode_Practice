class Solution {
    public static int minPatches(int[] nums, int n) {

	long max = 0;

	int cnt = 0;

	for (int i = 0; max < n;) {

		if (i >= nums.length || max < nums[i] - 1) {

			max += max + 1;

			cnt++;

		} else {

			max += nums[i];

			i++;

		}

	}
	return cnt;
   }
}