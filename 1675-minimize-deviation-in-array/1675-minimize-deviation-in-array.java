class Solution {
    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> set  = new TreeSet<>();
        for(int val:nums){
            if(val%2==0){
                set.add(val);
            }else{
                set.add(val*2);
            }
        }
        int res = Integer.MAX_VALUE;
        while(true){
            int max = set.last();
            res = Math.min(res,max-set.first());
            if(max%2==0){
                set.remove(max);
                set.add(max/2);
            }
            else
                break;
        }
        return res;
    }
}