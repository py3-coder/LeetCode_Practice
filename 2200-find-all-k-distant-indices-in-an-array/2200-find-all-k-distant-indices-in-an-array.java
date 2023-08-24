class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> res = new ArrayList<>();
        List<Integer> keylist = new ArrayList<>();
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]==key ){
                keylist.add(i);
            }
        }
        int last =0;
        for(int ele:keylist){
            int i= Math.max(last,ele-k);
            for(;i<=ele+k && i<nums.length;i++){
                res.add(i);
            }
            last=i;
        }
        return res;
        
    }
}