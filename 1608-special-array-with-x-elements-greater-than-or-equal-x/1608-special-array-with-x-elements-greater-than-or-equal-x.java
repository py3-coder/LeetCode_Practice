class Solution {
    public int specialArray(int[] nums) {
        int x = nums.length;
        int[] cnt = new int[x+1];
        
        for(int ele : nums)
            if(ele >= x)
                cnt[x]++;
            else
                cnt[ele]++;
        
        int res = 0;
        for(int i = cnt.length-1; i > 0; i--) {
            res += cnt[i];
            if(res == i)
                return i;
        }
        return -1;
    }
}