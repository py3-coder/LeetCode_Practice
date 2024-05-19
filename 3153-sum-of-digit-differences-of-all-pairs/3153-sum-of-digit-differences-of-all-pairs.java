class Solution {
    public long sumDigitDifferences(int[] nums) {
	long res = 0;
	int n = nums.length;
	int dn = (nums[0]+"").length();

	for(int j=0; j<dn; j++){
		int ct[] = new int[10];

		for(int i=0; i<n; i++){
			int curr = (nums[i]+"").charAt(j)-'0';

			ct[curr]++;
			res += (i-ct[curr]+1);
		}
	}
	return res;
   }
}